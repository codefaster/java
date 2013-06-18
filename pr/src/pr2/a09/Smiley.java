package pr2.a09;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Container;import java.awt.FlowLayout;import java.util.Locale;import java.util.ResourceBundle;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JPanel;import javax.swing.JToolBar;public class Smiley {	public static void main(String[] args) {		/* 		 * Load Locales		 */		Locale currentLocale = Locale.ENGLISH;		Locale spanish = new Locale("es","ES");		ResourceBundle menuBundle = ResourceBundle.getBundle("SmileyBundle.Menu",  currentLocale);		ResourceBundle labelBundle = ResourceBundle.getBundle("SmileyBundle.Labels", currentLocale);		/*		 * Create JFRAME		 */		final int YOFFSET = 60;		JFrame frame = new JFrame(labelBundle.getString(LabelItems.APPLICATION_TITLE.toString()));		Container container = frame.getContentPane();		container.setLayout(new BorderLayout());		/* 		 * Create MVC Structure		 */		SmileyModel m1 = new SmileyModel(250,250-YOFFSET,30,30,30,true);		CentralController c = new CentralController(m1);		ACPEEventPrinter ep = new ACPEEventPrinter();		FirstSmileyPanel smiley1 = new FirstSmileyPanel(m1);		m1.addPropertyChangeListener(smiley1);		m1.addPropertyChangeListener(ep);		smiley1.setBackground(Color.black);		JPanel ajustmentPanel = new JPanel();		ajustmentPanel.setLayout(new FlowLayout());		HeadAjustmentPanel headAdjust = new HeadAjustmentPanel(c);		AngleAdjustmentPanel angleAdjust = new AngleAdjustmentPanel(c);		EyeAdjustmentPanel eyeAdjust = new EyeAdjustmentPanel(c);		EmotionPanel emotionSet = new EmotionPanel(c);		m1.addPropertyChangeListener(headAdjust);		m1.addPropertyChangeListener(angleAdjust);		m1.addPropertyChangeListener(eyeAdjust);		m1.addPropertyChangeListener(emotionSet);		ajustmentPanel.add(headAdjust);		ajustmentPanel.add(angleAdjust);			ajustmentPanel.add(eyeAdjust);			ajustmentPanel.add(emotionSet);			container.add(smiley1, BorderLayout.CENTER);		container.add(ajustmentPanel, BorderLayout.NORTH);		container.add(new EmotionPanel(c), BorderLayout.SOUTH);				/*		 * Create Menu Items		 */		JMenuBar menuBar = new JMenuBar();		frame.setJMenuBar(menuBar);		JMenu fileMenu = new JMenu(menuBundle.getString(MenuItems.FILE.toString()));		JMenu changeLanguageMenu = new JMenu(menuBundle.getString(MenuItems.FILE_CHANGELANGUAGE.toString()));		JMenu smileyMenu = new JMenu(menuBundle.getString(MenuItems.SMILEY.toString()));		JMenu headMenu = new JMenu(menuBundle.getString(MenuItems.SMILEY_HEAD.toString()));		JMenu emotionMenu = new JMenu(menuBundle.getString(MenuItems.SMILEY_EMOTION.toString()));		JMenuItem germanItem = new JMenuItem(menuBundle.getString(MenuItems.FILE_CHANGELANGUAGE_GERMAN.toString()));		JMenuItem englishItem = new JMenuItem(menuBundle.getString(MenuItems.FILE_CHANGELANGUAGE_ENGLISH.toString()));		JMenuItem spanishItem = new JMenuItem(menuBundle.getString(MenuItems.FILE_CHANGELANGUAGE_SPANISH.toString()));		JMenuItem exitItem = new JMenuItem(menuBundle.getString(MenuItems.FILE_EXIT.toString()));		JMenuItem smileItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_SMILE.toString()));		JMenuItem incHeadRadiusItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_HEAD_INCRADIUS.toString()));		JMenuItem decHeadRadiusItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_HEAD_DECRADIUS.toString()));		JMenuItem pleasedItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_EMOTION_PLEASED.toString()));		JMenuItem sadItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_EMOTION_SAD.toString()));		JMenuItem resetItem = new JMenuItem(menuBundle.getString(MenuItems.SMILEY_RESET.toString()));		/* 		 * Add Menu Items		 */		menuBar.add(fileMenu);		menuBar.add(smileyMenu);		fileMenu.add(changeLanguageMenu);		fileMenu.add(exitItem);		changeLanguageMenu.add(germanItem);		changeLanguageMenu.add(englishItem);		changeLanguageMenu.add(spanishItem);		smileyMenu.add(smileItem);		smileyMenu.add(headMenu);		smileyMenu.add(emotionMenu);		smileyMenu.add(resetItem);		headMenu.add(incHeadRadiusItem);		headMenu.add(decHeadRadiusItem);		emotionMenu.add(pleasedItem);		emotionMenu.add(sadItem);		/*		 * Set Item's Action Commands & Add Action Listener		 */		sadItem.setActionCommand(Command.INPUT_SETSAD.toString());		pleasedItem.setActionCommand(Command.INPUT_SETPLEASED.toString());		incHeadRadiusItem.setActionCommand(Command.INPUT_INC_HEAD_RADIUS.toString());		decHeadRadiusItem.setActionCommand(Command.INPUT_DEC_HEAD_RADIUS.toString());		smileItem.setActionCommand(Command.INPUT_SMILE.toString());		exitItem.setActionCommand(Command.EXIT.toString());		sadItem.addActionListener(c);		pleasedItem.addActionListener(c);		incHeadRadiusItem.addActionListener(c);		decHeadRadiusItem.addActionListener(c);		smileItem.addActionListener(c);		exitItem.addActionListener(c);				/* 		 * Create JToolBar		 */		JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);		container.add(toolbar,BorderLayout.EAST);		System.out.println(Smiley.class.getResource(""));		ImageIcon happyIcon = new ImageIcon(Smiley.class.getResource(IconPaths.HAPPY_ICON.toString()));		ImageIcon sadIcon = new ImageIcon(Smiley.class.getResource(IconPaths.SAD_ICON.toString()));		ImageIcon biggerIcon = new ImageIcon(Smiley.class.getResource(IconPaths.LOVE_ICON.toString()));		ImageIcon smallerIcon = new ImageIcon(Smiley.class.getResource(IconPaths.HATE_ICON.toString()));		JButton happyButton = new JButton(happyIcon);		JButton sadButton = new JButton(sadIcon);		JButton biggerButton = new JButton(biggerIcon);		JButton smallerButton = new JButton(smallerIcon);		toolbar.add(happyButton);		toolbar.add(sadButton);		toolbar.add(biggerButton);		toolbar.add(smallerButton);		/* 		 * Set Toolbar's ActionCommands & Add ActionListeners		 */		happyButton.setActionCommand(Command.INPUT_SETPLEASED.toString());		sadButton.setActionCommand(Command.INPUT_SETSAD.toString());		biggerButton.setActionCommand(Command.INPUT_INC_HEAD_RADIUS.toString());		smallerButton.setActionCommand(Command.INPUT_DEC_HEAD_RADIUS.toString());		happyButton.addActionListener(c);		sadButton.addActionListener(c);		biggerButton.addActionListener(c);		smallerButton.addActionListener(c);		/*		 * Show Frame		 */		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		frame.setSize(580, 500);        frame.setVisible(true);		}}