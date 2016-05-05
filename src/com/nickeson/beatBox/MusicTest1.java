package com.nickeson.beatBox;

//JDK 1.8.0
import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

/****************************************************************************
 * <b>Title</b>: MusicTest1.java <p/>
 * <b>Project</b>: HeadStart Java BeatBox <p/>
 * <b>Description: </b> A Java MIDI BeatBox<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 5, 2016<p/>
 * updates:
 ****************************************************************************/

public class MusicTest1 {

	// default no-arg constructor
	public MusicTest1() {
	}

	public void play() {
		// watch for MidiUnavailableException, take action if found
		try {
			// call static method from MidiSystem to create a Sequencer object
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Successfully got a Sequencer");
		} catch (MidiUnavailableException ex) { // if we find the exception, do this
			System.out.println("Bummer, bro");
			ex.getMessage();
			ex.printStackTrace();
		}
	}
	
	// main method
	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}
}