package pn2sc;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Config {
	private String basePath;
	private String sourceFile;
	private String targetFile;
	private long debugTransform;
	private int changeDriven;
	
	public void processParameters(String[] args) {
		Options options = new Options();
		options.addOption("basePath", true, "path containing models");
		options.addOption("sourceFile", true, "source PetriNet file");
		options.addOption("targetFile", true, "target StateChart file");
		options.addOption("debugTransform", true, "debug level: int");
		options.addOption("changeDriven", true, "true/false, true: after transformation do some change driven transformation");
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		
		try {
			cmd = parser.parse( options, args);
			
			if (cmd.getOptionValue("basePath") != null) {
				basePath = cmd.getOptionValue("basePath");
			}
			if (cmd.getOptionValue("sourceFile") != null) {
				sourceFile = cmd.getOptionValue("sourceFile");
			}
			if (cmd.getOptionValue("targetFile") != null) {
				targetFile = cmd.getOptionValue("targetFile");
			}
			if (cmd.getOptionValue("debugTransform") != null) {
				debugTransform = new Long(cmd.getOptionValue("debugTransform"));
			}
			if (cmd.getOptionValue("changeDriven") != null) {
				changeDriven = new Integer(cmd.getOptionValue("changeDriven"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public String getTargetFile() {
		return targetFile;
	}
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}


	public String getBasePath() {
		return basePath;
	}


	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


	public int getChangeDriven() {
		return changeDriven;
	}


	public void setChangeDriven(int changeDriven) {
		this.changeDriven = changeDriven;
	}


	public long getDebugTransform() {
		return debugTransform;
	}


	public void setDebugTransform(long debugTransform) {
		this.debugTransform = debugTransform;
	}
}
