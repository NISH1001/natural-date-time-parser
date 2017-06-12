package com.codingparadox.core.languagemodel;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * It is the implementation for Ngram language model.
 * The data is stored in the map with ngram type
 * and the corresponding Ngram data
 *
 */
public class NgramLanguageModel implements LanguageModel{
	
	/**
	 * The actual data is stored here.
	 * It may be unigram, bigram, trigram, etc based on the type
	 */
	private Map<NgramType, Ngram> data;
	
	public NgramLanguageModel() {
		this.data = new EnumMap<NgramType, Ngram>(NgramType.class);
	}
	
	public void addNgram(Ngram ngram, NgramType ngramType) {
		this.data.put(ngramType, ngram);
	}
	
	public Ngram getNgram(NgramType ngramType) {
		return this.getNgram(ngramType);
	}

	public void updateModel(List<List<String>> tokens) {
		// TODO Auto-generated method stub
		
	}

	public double getNgramCount(List<String> ngramSequence, NgramType ngramType) {
		return this.data.get(ngramType).getNgramCount(ngramSequence);
	}

	public int getVocabularySize(NgramType ngramType) {
		return this.data.get(ngramType).getVocabularySize();
	}

	public Set<List<String>> getUniqueTokens(NgramType ngramType) {
		return this.data.get(ngramType).getUniqueTokens();
	}

	public double getTotalNumberofTokens(NgramType ngramType) {
		return this.data.get(ngramType).getTotalNumberOfTokens();
	}

}
