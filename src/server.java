import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class server {
	
	private final JFrame frame;
	
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	
	public static void main(String [] args) {
		
		new NativeDiscovery().discover();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new server(args);
            }
        });
		
	}
	
	
	public server(String[] args) {
        frame = new JFrame("Media Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
        frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().playMedia(args[0]);
    }
}
