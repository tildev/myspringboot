package com.tildev.myspringboot.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseVo implements Serializable{

	private static final long serialVersionUID = -6271463555040657916L;

	private ResponseHeaderVo headerVo = new ResponseHeaderVo();
	private ResponseBodyVo bodyVo = new ResponseBodyVo();
	
	public ResponseHeaderVo getHeaderVo() {
		return headerVo;
	}
	public void setHeaderVo(ResponseHeaderVo headerVo) {
		this.headerVo = headerVo;
	}
	public ResponseBodyVo getBodyVo() {
		return bodyVo;
	}
	public void setBodyVo(ResponseBodyVo bodyVo) {
		this.bodyVo = bodyVo;
	}
}
