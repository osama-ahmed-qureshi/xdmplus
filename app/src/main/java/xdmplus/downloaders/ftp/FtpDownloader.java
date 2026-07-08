package xdmplus.downloaders.ftp;

import xdmplus.XDMConstants;
import xdmplus.downloaders.AbstractChannel;
import xdmplus.downloaders.Segment;
import xdmplus.downloaders.SegmentDownloader;
import xdmplus.downloaders.metadata.HttpMetadata;

public class FtpDownloader extends SegmentDownloader {
	private HttpMetadata metadata;
	//private String newFileName;

	public FtpDownloader(String id, String folder, HttpMetadata metadata) {
		super(id, folder);
		this.metadata = metadata;
	}

	@Override
	public AbstractChannel createChannel(Segment segment) {
		FtpChannel hc = new FtpChannel(segment, metadata.getUrl());
		return hc;
	}

	@Override
	public int getType() {
		return XDMConstants.FTP;
	}

	@Override
	public boolean isFileNameChanged() {
		return false;
		/*
		 * Logger.log("Checking for filename change " + (newFileName != null)); return
		 * newFileName != null;
		 */
	}

	@Override
	public String getNewFile() {
		return null;//newFileName;
	}

	@Override
	protected void chunkConfirmed(Segment c) {
		
	}

	@Override
	public HttpMetadata getMetadata() {
		return this.metadata;
	}

}
