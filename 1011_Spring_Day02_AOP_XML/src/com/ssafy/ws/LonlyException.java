package com.ssafy.ws;

public class LonlyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void handleException() {
		System.out.println("혼자서는 볼 수 없습니다. 친구와 오세요 ㅋ");
	}

}
