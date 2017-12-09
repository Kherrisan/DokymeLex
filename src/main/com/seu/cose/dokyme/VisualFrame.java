package com.seu.cose.dokyme;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zdksc on 2017/12/9.
 */
public class VisualFrame extends JFrame {
    private Layout<State, Transition> layout;
    private BasicVisualizationServer<State, Transition> server;

    public VisualFrame(Graph<State, Transition> graph) {
        super("Hello World");
        layout = new CircleLayout<State, Transition>(graph);
        layout.setSize(new Dimension(200, 200));
        server = new BasicVisualizationServer<>(layout);
        server.setPreferredSize(new Dimension(350, 350));
        server.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        server.getRenderer().getVertexLabelRenderer().setPosition(edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position.CNTR);
        server.getRenderContext().setVertexFillPaintTransformer(e -> Color.WHITE);
        server.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(server);
        pack();
        setVisible(true);
    }
}
