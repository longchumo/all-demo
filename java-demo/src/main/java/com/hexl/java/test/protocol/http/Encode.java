package com.hexl.java.test.protocol.http;

public enum Encode {
	GBK((byte)0),UTF8((byte)1);
	private byte value=1;
	private Encode(byte value){
		this.value=value;
	}
	public byte getValue(){
		return value;
	}
}
