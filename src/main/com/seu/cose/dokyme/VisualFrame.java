package com.seu.cose.dokyme;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zdksc on 2017/12/9.
 */
public class VisualFrame extends JFrame {
    private Layout<State, Transition> layout;
    private VisualizationViewer<State, Transition> server;

    public VisualFrame(Graph<State, Transition> graph) {
        super("Hello World");

        layout = new CircleLayout<State, Transition>(graph);
        layout.setSize(new Dimension(500, 500));
        server = new VisualizationViewer<State, Transition>(layout);
        server.setPreferredSize(new Dimension(600, 600));
        server.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        server.getRenderer().getVertexLabelRenderer().setPosition(edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position.CNTR);
        server.getRenderContext().setVertexFillPaintTransformer((state) -> {
            try {
                Integer.valueOf(state.tag);
                return Color.WHITE;
            } catch (Exception e) {
                return Color.GREEN;
            }
        });
        server.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        server.setGraphMouse(gm);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(server);
        pack();
        setVisible(true);
    }
}
