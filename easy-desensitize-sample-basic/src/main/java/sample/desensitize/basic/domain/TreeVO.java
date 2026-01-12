package sample.desensitize.basic.domain;

import java.util.List;

import com.github.zhengyuelaii.desensitize.core.annotation.MaskingField;
import com.github.zhengyuelaii.desensitize.core.handler.KeepFirstAndLastHandler;

public class TreeVO {

	private String id;

	@MaskingField(typeHandler = KeepFirstAndLastHandler.class)
	private String name;

	private List<TreeVO> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TreeVO [id=" + id + ", name=" + name + ", children=" + children + "]";
	}

}
