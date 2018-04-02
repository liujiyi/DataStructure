package com.example.code;

/**
 * <p>描述：邻接链表使用顶点作为对象构建图的数据结构</p>
 * 有向图
 * 作者： liujiyi<br>
 * 日期： 2018/4/2<br>
 */
public class Vertex2Graph {
    /**
     * 顶点数、边数以及图的顶点集合
     */
    public Vertex[] vertexArray;
    public int vNum;
    public int eNum;

    /**
     * 顶点信息
     * 顶点信息 下一条顶点
     */
    public static class Vertex {
        public String name;
        public Vertex next;

        public Vertex(String name) {
            this.name = name;
        }
    }

    public Vertex2Graph(Vertex[] vertexArray, int vNum, int eNum) {
        this.vertexArray = vertexArray;
        this.vNum = vNum;
        this.eNum = eNum;
    }

    /**
     * 连接
     *
     * @param from
     * @param to
     */
    public void initGraph(String from, String to) {
        Vertex fromV = null;
        for (int x = 0; x < vertexArray.length; x++) {
            if (vertexArray[x].name.equals(from)) {
                fromV = vertexArray[x];
                break;
            }
        }
        //该顶点不能是vertexArray里面 否则会造成死循环
//        for (int x = 0; x < vertexArray.length; x++) {
//            if (vertexArray[x].name.equals(to)) {
//                toV = vertexArray[x];
//                break;
//            }
//        }
        Vertex toV = new Vertex(to);
        if (fromV != null && toV != null) {
            toV.next = fromV.next;
            fromV.next = toV;
        }
    }

    /**
     * 输入图的邻接表
     *
     * @param
     */
    public void outputGraph() {
        System.out.println("graph:");
        for (int i = 0; i < this.vNum; i++) {
            Vertex vertex = this.vertexArray[i];
            System.out.print(vertex.name);

            Vertex current = vertex.next;
            while (current != null) {
                System.out.print("-->" + current.name);
                current = current.next;
            }
            System.out.println();
        }
    }
}
