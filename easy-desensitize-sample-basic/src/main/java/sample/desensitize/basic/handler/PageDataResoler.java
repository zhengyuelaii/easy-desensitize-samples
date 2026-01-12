package sample.desensitize.basic.handler;

import java.util.Iterator;

import com.github.zhengyuelaii.desensitize.core.util.MaskingDataResolver;

import sample.desensitize.basic.util.Page;

public class PageDataResoler implements MaskingDataResolver<Page<?>> {

	@Override
	public Iterator<?> resolve(Page<?> source) {
		return source.getData().iterator();
	}

}
