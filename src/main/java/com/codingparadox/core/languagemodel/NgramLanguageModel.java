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
		
		for(NgramType ngramType : NgramType.values()) {
			this.data.put(ngramType, new Ngram(ngramType));
		}
	}
	
	public void addNgram(Ngram ngram, NgramType ngramType) {
		this.data.put(ngramType, ngram);
	}
	
	public Ngram getNgram(NgramType ngramType) {
		return this.getNgram(ngramType);
	}

	public void updateModel(List<List<String>> tokens) {
		// loop over each sentence
		for(List<String> sentence : tokens) {
			
			// skip sentences shorter than 3 words
			if(sentence.size() < NgramType.TRIGRAM.getValue()) {
				System.out.println("Skipping ngram generation for sentence : " + sentence);
				continue;
			}
			
			System.out.println(sentence);
			
			// generate ngrams for every type
			for(NgramType ngramType : NgramType.values()) {
				List<List<String>> ngrams = NgramUtils.generateNgrams(sentence, ngramType.getValue());
				// update the Ngram model accordingly
				for(List<String> ngram : ngrams) {
					this.data.get(ngramType).updateNgram(ngram);
				}
			}
		}
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
	
	@Override
	public String toString() {
		String toReturn = "";
		for(NgramType ngramType : NgramType.values()) {
			toReturn += "\n" + this.data.get(ngramType).toString();
		}
		
		return toReturn;
	}

}
