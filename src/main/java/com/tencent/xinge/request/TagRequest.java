package com.tencent.xinge.request;

import java.util.List;

public class TagRequest {

	/**
	 * 必要参数 <br>
	 * 取值： 1）1增加单个tag，对单个token而言 2）2删除单个tag，对单个token而言 3）3增加多个tag，对单个token而言
	 * 4）4删除多个tag，对单个token而言 5）5删除所有标签，对单个token而言 6）6标签覆盖接口（支持多个标签），对单个token而言
	 * 7）7为多个token添加单个tag 8）8为多个token删除单个tag
	 * 9）9批量设置标签（每次调用最多允许设置20对，每个对里面标签在前，token在后）
	 * 10）10批量删除标签（每次调用最多允许设置20对，每个对里面标签在前，token在后）
	 */
	private int operator_type;

	/**
	 * 必要参数 <br>
	 * 取值： 1）android 2）ios
	 */
	private String platform;

	/**
	 * 可选参数<br>
	 * operator_type =1,2,3,4,5,6,7,8时必填 1）operator_type
	 * =1,2,3,4,5,6时如果该参数包含多个token只会设置第一个token 2）格式eg：["token1","token2"]
	 */
	private List<String> token_list;

	/**
	 * 可选参数<br>
	 * operator_type =1,2,3,4,6,7,8时必填 1）operator_type
	 * =1,2,3,4,6,7,8时如果该参数包含多个tag时，如果只是对单个tag操作，则只会设置第一个tag 2）格式eg：["tag1","tag2"]
	 */
	private List<String> tag_list;

	/**
	 * 可选参数<br>
	 * operator_type =9,10时必填 1）格式eg： [["tag1","token1"],["tag2","token2"]]
	 */
	private List<String> tag_token_list;

	/**
	 * 可选参数<br>
	 * 接口调用时，在应答包中信鸽会回射该字段,可用于异步请求
	 * 
	 */
	private int seq;

	/**
	 * 可选参数<br>
	 * 接口操作人员类型：qq，rtx，email、other
	 * 
	 */
	private String op_type;

	/**
	 * 可选参数<br>
	 * 接口操作人员类型：接口操作人员id（QQ\rtx\email）
	 * 
	 */
	private String op_id;

	/**
	 * 
	 * @param operator_type
	 * @param platform 取值： 1）android 2）ios
	 */
	public TagRequest(int operator_type, String platform) {
		this.operator_type = operator_type;
		this.platform = platform;
	}

	public int getOperator_type() {
		return operator_type;
	}

	public void setOperator_type(int operator_type) {
		this.operator_type = operator_type;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public List<String> getToken_list() {
		return token_list;
	}

	public void setToken_list(List<String> token_list) {
		this.token_list = token_list;
	}

	public List<String> getTag_list() {
		return tag_list;
	}

	public void setTag_list(List<String> tag_list) {
		this.tag_list = tag_list;
	}

	public List<String> getTag_token_list() {
		return tag_token_list;
	}

	public void setTag_token_list(List<String> tag_token_list) {
		this.tag_token_list = tag_token_list;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getOp_type() {
		return op_type;
	}

	public void setOp_type(String op_type) {
		this.op_type = op_type;
	}

	public String getOp_id() {
		return op_id;
	}

	public void setOp_id(String op_id) {
		this.op_id = op_id;
	}

}
