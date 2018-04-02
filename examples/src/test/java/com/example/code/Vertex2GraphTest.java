package com.example.code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>描述：</p>
 * 作者： liujiyi<br>
 * 日期： 2018/4/2<br>
 */
public class Vertex2GraphTest {
    Vertex2Graph graph;

    @Before
    public void setUp() throws Exception {
        Vertex2Graph.Vertex v1 = new Vertex2Graph.Vertex("v1");
        Vertex2Graph.Vertex v2 = new Vertex2Graph.Vertex("v2");
        Vertex2Graph.Vertex v3 = new Vertex2Graph.Vertex("v3");
        Vertex2Graph.Vertex v4 = new Vertex2Graph.Vertex("v4");
        Vertex2Graph.Vertex[] array = {v1, v2, v3, v4};
        graph = new Vertex2Graph(array, 4, 5);
    }

    @Test
    public void initGraph() throws Exception {

    }

    @Test
    public void outputGraph() throws Exception {
        String str1 = "v1";
        String str2 = "v2";
        String str3 = "v3";
        String str4 = "v4";
        graph.initGraph(str1, str2);
        graph.initGraph(str1, str3);
        graph.initGraph(str2, str4);
        graph.initGraph(str2, str1);
        graph.initGraph(str3, str4);

        graph.outputGraph();
    }

}