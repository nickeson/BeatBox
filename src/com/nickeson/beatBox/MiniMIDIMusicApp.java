package com.nickeson.beatBox;

//JDK 1.8.0
import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

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

public class MiniMIDIMusicApp {

	// default no-arg constructor
	public MiniMIDIMusicApp() {
	}

	public void play() {
		// watch for MidiUnavailableException, take action if found
		try {
			
			// call static method from MidiSystem to create a Sequencer object
			Sequencer player = MidiSystem.getSequencer();
			System.out.println("Successfully got a Sequencer");
			
			// open sequencer so we can use it
			player.open();
			
			// setup a new sequence object
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			// setup a new track object
			Track track = seq.createTrack();
			
			// put some MIDI events into the Track
			ShortMessage c = new ShortMessage();
			c.setMessage(192, 2, 88, 127);
			MidiEvent noteOn2 = new MidiEvent(c, 1);
			track.add(noteOn2);
			
			ShortMessage d = new ShortMessage();
			d.setMessage(192, 2, 88, 127);
			MidiEvent noteOff2 = new MidiEvent(d, 16);
			track.add(noteOff2);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 2, 29, 127);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 2, 29, 127);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			// give the sequence (seq) to the sequencer (player)
			player.setSequence(seq);
			// start the sequencer (hit play)
			player.start();
			
		} catch (Exception ex) { // if we find the exception, do this
			
			System.out.println("Bummer, bro");
			ex.printStackTrace();
		}
	}
	
	// main method
	public static void main(String[] args) {
		MiniMIDIMusicApp mt = new MiniMIDIMusicApp();
		mt.play();
	}
}