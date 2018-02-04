import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.List;

public class Mp3Player extends JFrame {
	MP3 song;
	ArrayList songlist;
	int numsong = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3Player frame = new Mp3Player();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mp3Player() {
		song = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Open a file choosing dialog
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			File selectedFile = fileChooser.getSelectedFile();
			//Create a new mp3 file based on the file selected
			song = new MP3(selectedFile.getAbsolutePath());
			songlist.add(song);
			
			}
		});
		btnOpen.setBounds(10, 54, 89, 23);
		contentPane.add(btnOpen);
		
		
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numsong++;
				if(song != null && numsong == 1) {
					
				}
			}
		});
		btnPlay.setBounds(106, 54, 89, 23);
		contentPane.add(btnPlay);
		
		
		
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					song.close();
					numsong = 0;
			}
		});
		btnStop.setBounds(205, 54, 89, 23);
		contentPane.add(btnStop);
	}
}
