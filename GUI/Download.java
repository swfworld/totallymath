package GUI;

import java.io.*;
import java.net.*;
import java.util.*;

// This class downloads a file from a URL.
class Download extends Observable implements Runnable {
	private static final int MAX_BUFFER_SIZE = 1024;
	public static final String STATUSES[] = {"Downloading",
	"Paused", "Complete", "Cancelled", "Error"};
	public static final int DOWNLOADING = 0;
	public static final int PAUSED = 1;
	public static final int COMPLETE = 2;
	public static final int CANCELLED = 3;
	public static final int ERROR = 4;
	
	private URL url;
	private int size;
	private int downloaded;
	private int status;
	public Download(URL url) {
	    this.url = url;
	    size = -1;
	    downloaded = 0;
	    status = DOWNLOADING;
	    download();
	}
	public String getUrl() {
	    return url.toString();
	}
	public int getSize() {
	    return size;
	}
	public float getProgress() {
	    return ((float) downloaded / size) * 100;
	}
	public int getStatus() {
	    return status;
	}
	public void pause() {
	    status = PAUSED;
	    stateChanged();
	}
	public void resume() {
	    status = DOWNLOADING;
	    stateChanged();
	    download();
	}
	public void cancel() {
	    status = CANCELLED;
	    stateChanged();
	}
	private void error() {
	    status = ERROR;
	    stateChanged();
	}
	private void download() {
	    Thread thread = new Thread(this);
	    thread.start();
	}
	private String getFileName(URL url) {
	    String fileName = url.getFile();
	    return fileName.substring(fileName.lastIndexOf('/') + 1);
	}
	public void run() {
	    RandomAccessFile file = null;
	    InputStream stream = null;
	
	    try {
	        // Open connection to URL.
	        HttpURLConnection connection =
	                (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Range",
	                "bytes=" + downloaded + "-");
	        connection.connect();
	        if (connection.getResponseCode() / 100 != 2) {
	            error();
	        }
	        int contentLength = connection.getContentLength();
	        if (contentLength < 1) {
	            error();
	        }
	        if (size == -1) {
	            size = contentLength;
	            stateChanged();
	        }
	        file = new RandomAccessFile(getFileName(url), "rw");
	        file.seek(downloaded);
	        stream = connection.getInputStream();
	        while (status == DOWNLOADING) {
	            byte buffer[];
	            if (size - downloaded > MAX_BUFFER_SIZE) {
	                buffer = new byte[MAX_BUFFER_SIZE];
	            } else {
	                buffer = new byte[size - downloaded];
	            }
	
	            // Read from server into buffer.
	            int read = stream.read(buffer);
	            if (read == -1)
	                break;
	
	            // Write buffer to file.
	            file.write(buffer, 0, read);
	            downloaded += read;
	            stateChanged();
	        }
	        if (status == DOWNLOADING) {
	            status = COMPLETE;
	            stateChanged();
	        }
	    } catch (Exception e) {
	        error();
	    } finally {
	        // Close file.
	        if (file != null) {
	            try {
	                file.close();
	            } catch (Exception e) {}
	        }
	
	        // Close connection to server.
	        if (stream != null) {
	            try {
	                stream.close();
	            } catch (Exception e) {}
	        }
	    }
	}
	private void stateChanged() {
	    setChanged();
	    notifyObservers();
	}
}