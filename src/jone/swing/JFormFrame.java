/*- 
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package jone.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Frame to create forms
 *
 * @see
 * @author Jonas Mayer (jonas.mayer.developer@gmail.com)
 */
public class JFormFrame extends JFrame {

    protected int _xFrame = 0;
    protected int _yFrame = 0;
    protected int _widthFrame = 0;
    protected int _heightFrame = 0;
    protected int _widthPanel = 0;
    protected int _heightPanel = 0;

    //internals componets
    //proportion of screen width/height
    private double _proportion;
    protected List<Component> components;
    protected JPanel internalPanel;
    protected JScrollPane internalScrollPane;
    protected JPanel containerPanel;

    /**
     * Contructor with position in screen and width, the height is determined by
     * the screen size
     *
     * @param position
     * @param width
     */
    public JFormFrame(Point position, int width) {
        super();
        _xFrame = position.x;
        _yFrame = position.y;
        _widthFrame = width;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        _heightFrame = dimension.height - 10;
        _widthPanel = _widthFrame - 20;
        _heightPanel = _heightFrame - 100;
        initializeView();
    }//end of the method

    /**
     * Initialize view, define settings and create internal components
     */
    private void initializeView() {
        components = new ArrayList();
        setLayout(null);
        setVisible(true);
        setBounds(_xFrame, _yFrame, _widthFrame, _heightFrame);

        internalScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        containerPanel = new JPanel();
        internalPanel = new JPanel();

        containerPanel.setLayout(null);
        internalPanel.setLayout(null);
        containerPanel.setBounds(8, 0, _widthPanel, _heightPanel);
        internalScrollPane.setBounds(0, 0, _widthPanel, _heightPanel);
        internalPanel.setBounds(0, 0, _widthPanel - 20, _heightPanel);
        internalPanel.setPreferredSize(new Dimension(_widthPanel - 20, _heightPanel));

        internalPanel.setBackground(Color.WHITE);

        containerPanel.add(internalScrollPane);
        internalScrollPane.setViewportView(internalPanel);
        add(containerPanel);

        //define adaptation listener
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adapt(e);
            }
        });
    }//end of the method

    /**
     * Adapt the frame to the actual size
     *
     * @param e ComponentEvent
     */
    private void adapt(ComponentEvent e) {
        Dimension dimension = e.getComponent().getSize();
        _widthFrame = dimension.width;
        _heightFrame = dimension.height;
        _widthPanel = _widthFrame - 30;
        _heightPanel = _heightFrame - 100;
        containerPanel.setBounds(8, 0, _widthPanel, _heightPanel);
        internalScrollPane.setBounds(0, 0, _widthPanel, _heightPanel);
    }//end of the method adapt

    /**
     * Set size of internal panel
     *
     * @param widthInternalPanel
     * @param heightInternalPanel
     */
    public void setInternalSize(int widthInternalPanel, int heightInternalPanel) {
        internalPanel.setBounds(0, 0, widthInternalPanel, heightInternalPanel);
        internalPanel.setPreferredSize(new Dimension(widthInternalPanel, heightInternalPanel));
    }//end of the method setInternalSize

    //main
    public static void main(String args[]) {
        JFormFrame f = new JFormFrame(new Point(0, 0), 500);
        f.setInternalSize(100, 800);
    }//end main
}//end of the class JFormFrame 
