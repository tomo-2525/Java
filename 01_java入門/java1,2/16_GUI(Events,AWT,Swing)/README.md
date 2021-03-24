# AWT (Abstract Window Toolkit)
AWTとSwingは、GUIをbuildするための標準的なコンポーネントを提供する。

<img src="https://github.com/tomo-2525/prog_sample/blob/master/Java/image/AWT_class_hierarchy.png" alt="AWT class Hierarchy" width="600px" height="500" />  

## APIクラス群
- java.awt.Component
    java.awtパッケージの上位に位置し、これを継承して以下の下位パッケージ
    - java.awt.Button
    ボタン処理を行うクラス
    - java.awt.Canvas
    コンポーネント上に描画するクラス
    - java.awt.Container
    コンテナに部品を設置できるクラス
    - java.awt.Panel
    パネルを利用できるクラス
    - java.applet.Applet
    アプレットを表示するためのクラス
    - java.awt.Graphics
    図形を扱うためのクラス
    - java.awt.Image
    イメージを扱うためのクラス

## Componet
コンポーネントは、グラフィカルな表現を持ったオブジェクトで抽象クラス。ユーザーとプログラムのインターフェースになる。ボタンやチェックボックスなどの部品のこと

### Button
```java
import java.awt.*;
import java.awt.event.*;

class BTN extends Frame {
    BTN() {
        super("Example: Button");
        final Button b = new Button("Press me!");
        

        b.addActionListener(new ActionListener() {// the event handler
            public void actionPerformed(ActionEvent ae) {
                b.setLabel("Thank you!"); 
            }
        });
        add(b);
        setSize(200, 100);
    }

    public static void main(String[] args){
        new BTN().setVisible(true);
    }

}

```

### Label and TextField
Labelはユーザーによって変えることができない文字列。  
TextFiledは、ユーザーによって編集可能な文字列
```java
import java.awt.*;
import java.awt.event.*;

class LTF extends Frame {
    LTF() {
        super("Example: Label & TextField");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setResizable(false);
        add(new Label("Cannot edit!"));
        final TextField tf = new TextField("Edit me!",37); 

        tf.addTextListener(new TextListener() {
        public void textValueChanged(TextEvent te) {System.out.println(te.paramString());}
        };

        add(tf);
        setSize(400,100);
    }

    public static void main(String[] args) {
    new LTF().setVisible(true);
    }
}
```

### List
```java
import java.awt.*;
import java.awt.event.*;

class LST extends Frame {

    LST() {
        super("Example: List");
    final List l = new List();
    l.add("I");
    l.add("like");
    l.add("programming");
    l.add("in");
    l.add("Java");
    l.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ie){
            System.out.println(ie.paramString());
        }
    });

    add(l);
    setSize(200,150);
    }

    public static void main(String[] args) {
        new LST().setVisible(true);
    }

}
```


### Menu, Menubar and MenuItem
```java
import java.awt.*; import java.awt.event.*;
class MNB extends Frame {

    MNB() {
        super("Example: MenuBar");
        final MenuBar mb = new MenuBar();
        setMenuBar(mb);
        final Menu m = new Menu("File"); 
        MenuItem mi;

        mi = new MenuItem("Exit"); 
        mi.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
            System.exit(0);
        }
        });
        m.add(mi);
        mb.add(m);
        setSize(250, 100);
    }

    public static void main(String[] args){
        new MNB().setVisible(true);
    }
}
```

# Layout Manager 
プログラムでGUIのレイアウトを決める時は、Layout　Managerを使う （コンテナ内のコンポーネントを調節する）  
`FrowLayout`,`BorderLayout`,`GridLayout`,`GridBagLayout`,`CardLayout`などがあるがここでは、2つ取り上げる。指定死なければFrowLayout（左から順番に配置）になる。
## BorderLayout
`Center`位置を中心に`North`,`South`,`West`,`East`という四隅に部品を配置する
```java
import java.awt.*;
import java.awt.event.*;

class BLM extends Frame {
    BLM() {
        super("Example: BorderLayout");
        setLayout(new BorderLayout());
        add(new Button("Center"),BorderLayout.CENTER); 
        add(new Button("East"),BorderLayout.EAST); 
        add(new Button("North"),BorderLayout.NORTH);
        add(new Button("South"),BorderLayout.SOUTH); 
        add(new Button("West"),BorderLayout.WEST); 
        setSize(200,200);
    }

    public static void main(String[] args){
        new BLM().setVisible(true);
    }
}
```

## GridLayout
配列のように部品を配置する
```java
import java.awt.*;
import java.awt.event.*;

class GLM extends Frame {
    GLM() {
        super("Example: GridLayout");
        setLayout(new GridLayout(2,2)); 
        add(new Button("1,1")); 
        add(new Button("1,2")); 
        add(new Button("2,1")); 
        add(new Button("2,2")); 
        setSize(250,100);
    }

    public static void main(String[] args){
        new GLM().setVisible(true);
    }
}
```

## Panel
部品の管理に使われる部品で部品を柔軟に配置できる
```java
import java.awt.*; 
import java.awt.event.*;

class PNL extends Frame {
    PNL() {
        super("Example: Panel");
        final Panel p = new Panel();
        p.add(new Button("1")); 
        p.add(new Button("2")); 
        p.add(new Button("3")); 
        add(p); 
        setSize(250,100);
    }

    public static void main(String[] args){
        new PNL().setVisible(true);
    }
}
```


# Swing
Swingのコンポーネントの名前は、`J`から始まる（JButton,JCheckBox,JComboBox,JList,JMenu etc...）
## 例
```java
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

class HLW extends JFrame {
    HLW() {
        super("Example: Swing GUI");
        final JButton b = new JButton("Show message!");
        b.addActionListener(new HLWButtonListener(b)); 
        add(b);
        setSize(250,100);    
    }

    class HLWButtonListener implements ActionListener {
    private JButton jb;

        HLWButtonListener(JButton b){
            this.jb = b
        }

        public void actionPerformed(ActionEvent e) {
            jb.setText("Hello World!");
        }
    }

    public static void main(String[] args) {
        new HLW().setVisible(true);
    }

}

```

## Creating New Window Frame
```java
// Dialog Box
import java.util.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class CreatNewFrame extends JFrame{
    JLabel client_title;
    JButton create_button;

    public CreatNewFrame(){
        getContentPane().setLayout(new GridLayout(1,0));
        create_button = new JButton("Create"); 
        create_button.addActionListener(new ButtonListener()); 
        getContentPane().add(create_button);
    }

    class ButtonListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            NewFrame nf = new NewFrame();

            nf.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            });

            nf.setTitle("New Window Frame"); 
            nf.setSize(200,150); 
            nf.setVisible(true);
        }
    }

    public static void main (String args[]) { 
        CreatNewFrame f = new CreatNewFrame(); 

        f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        f.setTitle("Create New Frame"); 
        f.setSize(200,150); 
        f.setVisible(true);
    }
}//end of CreatNewFrame

class NewFrame extends JFrame { 
    JLabel label;

    public NewFrame() { 
        getContentPane().setLayout(new FlowLayout());
        label = new JLabel("Another New Frame");
        getContentPane().add(label); 
    } // NewFrame constructor

}//end of NewFrame class
```
## Dialogs
```java
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

class DLG extends JFrame {
    DLG() {
        super("Example: Swing Dialog");
        final JFrame jf = this;
        final JButton jb = new JButton("Show a message dialog!");

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(jf,"This is a simple message dialog");}
        });

        add(jb); 
        setSize(250,100);   
    }

    public static void main(String[] args){
        new DLG().setVisible(true);
    }
}
```

## FileChooser
```java
import javax.swing.*;

class FCH extends JFrame {
    final JLabel jl = new JLabel();
    FCH() {
        super("Example: Swing FileChooser");
        add(jl); 
        setSize(300,50);
    }

    public static void main(String[] args) {
        final FCH fch = new FCH();
        final JFileChooser jfc = new JFileChooser();
        fch.setVisible(true);
        final int val = jfc.showOpenDialog(fch);
        if(val == JFileChooser.APPROVE_OPTION){fch.jl.setText("You chose to open this file: " + jfc.getSelectedFile().getName());}
    }
}
```

