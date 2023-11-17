package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyFile {

	public static void main(String[] args) {
		try (FileChannel srcChannel = new FileInputStream(new File("src/data", "infile.iso")).getChannel();
				FileChannel dstChannel = new FileOutputStream(new File("src/data", "outfile.iso")).getChannel();) {
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
