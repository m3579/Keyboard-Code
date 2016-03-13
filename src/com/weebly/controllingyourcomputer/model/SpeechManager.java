/**
 * 
 */
package com.weebly.controllingyourcomputer.model;

/**
 * An interface for objects used to manage speaking text to the user
 * (and possibly, in the future, listening to what they say)
 * 
 * @author Mihir Kasmalkar
 *
 */
public interface SpeechManager
{
	/**
	 * Speak the given text to the user
	 * @param text the text to speak
	 */
	void speak(String text);
	
	/**
	 * Speak the given text to the user at the given WPM (words per minute) rate
	 * @param text the text to speak
	 * @param rate the rate to speak at in words per minute
	 */
	void speak(String text, int rate);
}
