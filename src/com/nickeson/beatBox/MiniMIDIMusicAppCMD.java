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

public class MiniMIDIMusicAppCMD {

	// default no-arg constructor
	public MiniMIDIMusicAppCMD() {
	}

	public void play(int instrument, int note) {
		// watch for MidiUnavailableException, take action if found
		try {
			
			// call static method from MidiSystem to create a Sequencer object
			Sequencer player = MidiSystem.getSequencer();
			
			// open sequencer so we can use it
			player.open();
			
			// setup a new sequence object
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			// setup a new track object
			Track track = seq.createTrack();
			
			// put some MIDI events into the Track
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 127);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 127);
			MidiEvent noteOff = new MidiEvent(b, 1);
			track.add(noteOff);
			
			// give the sequence (seq) to the sequencer (player)
			player.setSequence(seq);
			
			// start the sequencer (hit play)
			player.start();
			
		} catch (Exception ex) { 
			// if we find an exception, provide a message why	
			System.out.println("Bummer, bro");
			ex.printStackTrace();
		}
	}
	
	// main method
	public static void main(String[] args) {
		// create new instance of MiniMIDIMusicAppCMD name 'mini'
		MiniMIDIMusicAppCMD mini = new MiniMIDIMusicAppCMD();
		
		// make sure we pass args when running this app
		if (args.length < 2) {
			System.out.println("Don't forget the instrument and note args");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}
}