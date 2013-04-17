import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

class tabPane extends JDialog
{
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTabbedPane tabPane;	
	private	JPanel	panel1;
	private	JPanel	panel2;
	private	JPanel	panel3;
	private	JEditorPane editPane;
	private	Frame	frame1;
	private	JDialog	dialog;
	Font font = new Font("Copperplate Gothic Bold",Font.BOLD,20);


	public tabPane()
	{	
		setVisible(true);
		setTitle( "Tabbed Pane Application" );
		setSize( 1450, 1000 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

		// Create a tabbed pane
		tabPane = new JTabbedPane();
	
		tabPane.addTab( "Page 1", panel1 );
		tabPane.addTab( "Page 2", panel2 );
		tabPane.addTab( "Page 3", panel3 );
		
		
		tabPane.setTabPlacement(JTabbedPane.LEFT);
		topPanel.add( tabPane, BorderLayout.CENTER );
		this.pack();
        this.setSize(780, 520);
        this.setLocation((MAX_X-this.getWidth())/2, (MAX_Y-this.getHeight())/2);

	}

	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout(null);
	    panel1.setVisible(true);
	    panel1.setBackground(Color.YELLOW); 
	    JLabel Hlink = new JLabel("<html><u>ICEWorldPeek</u></html>");
	    Hlink.setBounds(150,100,200,25);
	    panel1.add(Hlink);
	    panel1.setPreferredSize(new Dimension(1500,1000));
	    Hlink.setForeground(Color.BLUE);
	    Hlink.setFont(font);
	    Hlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    Hlink.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		editPane = new JEditorPane();
	    		editPane.setEditable(false);
				dialog = new JDialog(frame1,"Help HTML5");
	    		try{
	    			editPane.setPage("https://dl.dropboxusercontent.com/u/38163621/HTMLs/Manual1.html");
	    			editPane.addHyperlinkListener(new HyperlinkListener(){
	    				public void hyperlinkUpdate(HyperlinkEvent event) {
	    					if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
	    						try{
	    							editPane.setPage(event.getURL());
	    						}catch(IOException ioe){
	    							editPane.setContentType("text/html");
	    							editPane.setText("<html>Could not load</html>");
	    						}
	    					}
	    				}
	    			});
	    		}catch (IOException e1){
	    			editPane.setContentType("text/html");
	    			editPane.setText("<html>Could not load</html>");
	    		}
	    	    JScrollPane scrollPane = new JScrollPane(editPane);     
	    	    dialog.getContentPane().add(scrollPane);
	    	    dialog.setPreferredSize(new Dimension(1500,1000));
	    	    dialog.pack();
	    	    dialog.setVisible(true);
	    	}
	    });
	    
	}

	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout(null);
	    panel2.setVisible(true);
	    panel2.setBackground(Color.YELLOW); 
	    JLabel Hlink = new JLabel("<html><u>ICEPort</u></html>");
	    Hlink.setBounds(150,100,160,25);
	    panel2.add(Hlink);
	    panel2.setPreferredSize(new Dimension(1500,1000));
	    Hlink.setForeground(Color.BLUE);
	    Hlink.setFont(font);
	    Hlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    Hlink.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		editPane = new JEditorPane();
	    		editPane.setEditable(false);
				dialog = new JDialog(frame1,"Help HTML5");
	    		try{
	    			editPane.setPage("https://dl.dropboxusercontent.com/u/38163621/HTMLs/Manual2.html");
	    			editPane.addHyperlinkListener(new HyperlinkListener(){
	    				public void hyperlinkUpdate(HyperlinkEvent event) {
	    					if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
	    						try{
	    							editPane.setPage(event.getURL());
	    						}catch(IOException ioe){
	    							editPane.setContentType("text/html");
	    							editPane.setText("<html>Could not load</html>");
	    						}
	    					}
	    				}
	    			});
	    		}catch (IOException e1){
	    			editPane.setContentType("text/html");
	    			editPane.setText("<html>Could not load</html>");
	    		}
	    		 JScrollPane scrollPane = new JScrollPane(editPane);     
		    	 dialog.getContentPane().add(scrollPane);
		    	 dialog.setPreferredSize(new Dimension(1500,1000));
		    	 dialog.pack();
		    	 dialog.setVisible(true);
	    	}
	    });
	    
	}

	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
	    panel3.setVisible(true);
	    panel3.setBackground(Color.YELLOW); 
	    JLabel Hlink = new JLabel("<html><u>HELP!!</u></html>");
	    Hlink.setBounds(150,100,160,25);
	    panel3.add(Hlink);
	    panel3.setPreferredSize(new Dimension(1500,1000));
	    Hlink.setForeground(Color.BLUE);
	    Hlink.setFont(font);
	    Hlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    Hlink.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		editPane = new JEditorPane();
	    		editPane.setEditable(false);
				dialog = new JDialog(frame1,"Help HTML5");
	    		try{
	    			editPane.setPage("https://dl.dropboxusercontent.com/u/38163621/HTMLs/Manual3.html");
	    			editPane.addHyperlinkListener(new HyperlinkListener(){
	    				public void hyperlinkUpdate(HyperlinkEvent event) {
	    					if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
	    						try{
	    							editPane.setPage(event.getURL());
	    						}catch(IOException ioe){
	    							editPane.setContentType("text/html");
	    							editPane.setText("<html>Could not load</html>");
	    						}
	    					}
	    				}
	    			});
	    		}catch (IOException e1){
	    			editPane.setContentType("text/html");
	    			editPane.setText("<html>Could not load</html>");
	    		}
	    		 JScrollPane scrollPane = new JScrollPane(editPane);     
		    	 dialog.getContentPane().add(scrollPane);
		    	 dialog.setPreferredSize(new Dimension(1500,1000));
		    	 dialog.pack();
		    	 dialog.setVisible(true);
	    	}
	    });
	    
	}

 

	public static void doLoadCommand(JTextComponent textComponent,
		      String filename) {
		    FileReader reader = null;
		    try {
		      System.out.println("Loading");
		      reader = new FileReader(filename);

		      // Create empty HTMLDocument to read into
		      HTMLEditorKit htmlKit = new HTMLEditorKit();
		      HTMLDocument htmlDoc = (HTMLDocument) htmlKit
		          .createDefaultDocument();
		      // Create parser (javax.swing.text.html.parser.ParserDelegator)
		      HTMLEditorKit.Parser parser = new ParserDelegator();
		      // Get parser callback from document
		      HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
		      // Load it (true means to ignore character set)
		      parser.parse(reader, callback, true);
		      // Replace document
		      textComponent.setDocument(htmlDoc);
		      System.out.println("Loaded");

		    } catch (IOException exception) {
		      System.out.println("Load oops");
		      exception.printStackTrace();
		    } finally {
		      if (reader != null) {
		        try {
		          reader.close();
		        } catch (IOException ignoredException) {
		        }
		      }
		    }
		  }
}