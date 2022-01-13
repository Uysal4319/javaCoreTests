package fileOperations.futuretask;


public class DumpResult {
	
	private String dumpFileName;
	private long   offset;
	private long    len;
	
	public DumpResult() {
		
	}
	
	public DumpResult(String dumpFileName, long offset, int len) {
		this.dumpFileName = dumpFileName;
		this.offset = offset;
		this.len = len;
	}
	
	public long getOffset() {
		return offset;
	}
	
	public void setOffset(long offset) {
		this.offset = offset;
	}
	
	public long getLen() {
		return len;
	}
	
	public void setLen(long len) {
		this.len = len;
	}
	
	public String getDumpFileName() {
		return dumpFileName;
	}
	
	public void setDumpFileName(String dumpFileName) {
		this.dumpFileName = dumpFileName;
	}
	
	@Override
	public String toString() {
		return "DumpResult [dumpFileName=" + dumpFileName + ", offset=" + offset + ", len=" + len + "]";
	}
	
}
