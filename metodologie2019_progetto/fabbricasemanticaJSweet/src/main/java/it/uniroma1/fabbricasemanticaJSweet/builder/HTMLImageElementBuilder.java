package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLImageElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo immagine
 * @author Flavia Bonanni
 */
public class HTMLImageElementBuilder extends HTMLElementBuilder
{
	private String src;
	private long height;
	private long width;
	
	// costruttore con visibilità di package
	public HTMLImageElementBuilder() {}
	
	/**
	 * Aggiunge la fonte per l'elemento immagine
	 * @param s fonte
	 * @return l'elemento immagine
	 */
	public HTMLImageElementBuilder setSrc(String s)
	{
		src = s;
		return this;
	}
	
	/**
	 * Imposta l'altezza per l'elemento immagine
	 * @param h altezza
	 * @return l'elemento immagine
	 */
	public HTMLImageElementBuilder setHeight(long h)
	{
		height = h;
		return this;
	}
	
	/**
	 * Imposta l'ampiezza per l'elemento immagine
	 * @param w ampiezza
	 * @return l'elemento immagine
	 */
	public HTMLImageElementBuilder setWidth(long w)
	{
		width = w;
		return this;
	}
			
	@Override
	public HTMLImageElement build() 
	{
		HTMLImageElement imageElement = document.createElement(StringTypes.img);
		if (src != null) imageElement.src = this.src;
		if (height != 0) imageElement.height = this.height;
		if (width != 0) imageElement.width = this.width;
		return imageElement;
	}
}