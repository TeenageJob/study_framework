package org.plugin.search;

import org.apache.lucene.document.Document;
import org.plugin.search.bean.IndexData;
import org.plugin.search.bean.SearchResult;

public interface SearchEngine {

    IndexData createIndexData();

    SearchResult createSearchResult(Document document);
}
