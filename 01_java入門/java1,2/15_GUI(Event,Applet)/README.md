# Event and Component Handling(イベント処理とコンポーネント処理)の概要
アプリケーションのためのGUIを作る時、どのようにユーザの動きを処理するのか、、  
それは、ボタンが押された時やメニューが選択された時などに生じる`event`を処理すれば良い。`event`は、オブジェクトでソースの状態の移り変わりを表している。その移り変わりを認識するのが`listener`である。
 
- evetを処理する流れ (The Delegation Event Model)  
①ユーザーがマウス、ボタンなどを操作する  
②Sourceがeventを発生させ、listenerの集合に通知する  
③listenerがinterfaceを実装する  

## イベント処理する時に使うクラスたち(Event class)
### event classの階層
<img src="https://github.com/tomo-2525/prog_sample/blob/master/Java/image/event_class_hierarchy.png" alt="event class の階級" width="500px" height="300" />  

#### EventObject class
- EventObjectが持ってるメソッド  
`getSource()`は、objectが生成したeventを返すメソッド  
`toSource()`は、eventの中身をStringで返すメソッド  

#### AWTEvent class
- AWtEventが持っているメソッド
`AWTevent(Object source, int id)`Sourceは、Objectでありeventを生成します。idは、eventのtypeを識別します。  
`getID()`はeventのtypeを返すメソッド

- AWT Event Classes
配置されたGUI部品のイベント処理は、部品によって`イベントクラス``イベントリスナークラス``イベント処理メソッド`によって処理される。それぞれの組み合わせを下に示す。

    |　イベントクラス | イベントリスナークラス | イベント処理メソッド | GUI 部品 |
    ----|----|----|---- 
    |ActionEvent| ActionListener | actionPerformed | Button,List,MenuItem,TextField |
    |AdjustmentEvent | AdjustmentListener| adjustmentValueChanged | Scrollbar |
    |ItemEvent |ItemListener| itemStateChanged | Checkbox,Choice,CheckboxMenuItem,List |
    |ComponentEvent| ComponentListener|  まだやってない   |  まだやってない   |
    |ContainerEvent |ContainerListener|  まだやってない   |  まだやってない   |
    |FocusEvent| FocusListener|  まだやってない   |  まだやってない   |
    |KeyEvent| KeyListener| KeyListener |  keyPressed, keyReleased, KeyTyped |
    |MouseEvent| (MouseListener), (MouseMotionListener)| (MouseAdapter), (MouseMotionAdapter)  | (mouseClicked, mouseEntered, mouseExited, mousePressed, mouseReleased),(mouseDragged, mouseMoved)|
    |TextEvent |TextListener|  まだやってない   | まだやってない    |
    |WindowEvent| WindowListener|    まだやってない |  まだやってない   |


### event handlingの設定
イベント処理の一連の動作を行うためには、イベント処理の設定をしなければいけない。イベントが発生するオブジェクトに`リスナーオブジェクト`を組み込み、イベント処理のメソッドを定義しておく。構造として、イベントクラス名、イベントリスナークラス名、アダプタークラス名を記述する。`イベントリスナー`は、イベント発生時に対応するアクションを実行するクラス。`アダプタークラス`は、イベントリスナーにイベント処理メソッドを定義するためのクラス。
```java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class hoge extends Applet{
    Image imgs;
    int px,py;

    public void init(){
        imgs = getImage(getDocumentBase(), "usagi.jpg");

        //↓↓は、イベント処理の一連の動作を行うための設定
        addMouseMotionListener(//(addイベントリスナークラス名)イベントリスナーをアプレットに組み込む
            new MouseMotionAdapter(){//(アダプタークラス名)イベントリスナーにイベント処理メソッドを定義するためのクラス
                public void mouseMoved(MouseEvent e){//(イベントクラス名 e)
                    //マウスムーブ時のイベント処理
                    px = e.getX();
                    py = e.getY();
                    repaint();
                }
            }
        );
    }

    public void paint(){
        g.drawImage(imgs,px,py,this);
    }
    
}

```

## コンポーネント処理する時に使うクラスたち(Applet class)
GUI部品のクラスは、java.awt.Componentクラスを継承しているので、ここでは、コンポーネント処理と呼ぶ
### Applet classの階層
<img src="https://github.com/tomo-2525/prog_sample/blob/master/Java/image/applet_class.png" alt="event class の階級" width="500px" height="500" />  

#### Component class
`component`とは、Button, LabelなどのGUI部品になるもので、`java.awt.Component`にあります。
- Componentが持っているメソッド(listenerに登録と登録解除することを可能にするメソッドがある)  
void add`Type`Listener(`Type`Listener tl)  
void remove`Type`Listener(`Type`Listener tl)  

# Appletの概要
Appletとは、WebページのHTMLから参照できるプログラム

## Appletの動作
アプレットが実行される時、次のような順序でメソッドが呼び出される。ユーザーはメソッドの定義内容を変更し、必要とする処理を実行させる。変更しない場合は、Appletクラスで定義されている基本メソッドが実行される  
一般的には、以下の順序でメソッドが実行される  
①init():ブラウザがアプレットを読みこんだ時に呼び出される  
②start():アプレットの実行を開始する時にapplet viewerまたはwebブラウザーから呼び出される  
③paint():アプレットの開始時に呼び出される  
④run():スレッドの実行時に呼び出される  
⑤stop():アプレットの終了時に呼び出される。例えばアプレットが表示されているWebページから、別のホームページへ移動したりする場合に呼び出されます。  
⑥destroy():アプレットが完全に終了される時にapplet viewerまたはwebブラウザーから呼び出される


  
# event listenerの具体例
## MouseListener (Low-level Listenr) 
MouseListenerは、インターフェースであるために、必ずオーバーライドしないといけないメソッドがある  
マウスが押されたなどのイベントを監視して、イベント発生時にアクションを実行するサンプルです。
```java:MLF.java
import java.awt.*;
import java.awt.event.*;

class MLF extends Frame implements MouseListener {

    MLF() {
        super("Example: MouseListener");
        addMouseListener(this);//このメソッドで、コンポーネントに登録する
        setSize(250, 100);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {System.out.println(me);}

    public static void main(String[] args) {
        new MLF().setVisible(true);
    }
}
```
```
javac MLF.java  コンパイル
java MLF        実行
```

## Adapter classes (low-lebel event listener)  
adapterは、イベントリスナーにイベント処理のメソッドを定義するためのクラス
`<applet></applet>`は、HTMLのタグで、そのタグ内でjava appletコードの実行が反映される
マウスをクリックし続けていると画面が赤くなり、クリックをやめると緑になる
```java
import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

/*
<applet code="MouseInnerDemo" width=100 height=100>
</applet>
*/

public class MouseInnerDemo extends Applet {
    public void init() { 
        setBackground(Color.green); 
        addMouseListener(new MyMouseAdapter());
    }

    class MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent me) { 
            setBackground(Color.red);
            repaint();
        }
        public void mouseReleased(MouseEvent me) { 
            setBackground(Color.green);
            repaint();
        }
    } 
}
```
```
javac MouseInnerDemo.java           コンパイル
appletviewer MouseInnerDemo.java    実行
```


## ActionListener
ボタンが押されたなどのイベントを監視して、イベント発生時にアクションを実行するサンプルです。
```java
import java.awt.*;
import java.awt.event.*;

public class HelloAWT extends Frame {
    Label contents;
    Button dispbutton;

    // Using Frame
    public HelloAWT() { // Constructor
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        contents = new Label("           "); // CreateLabelobject add(contents); // Add the label to this Frame
        dispbutton = new Button("Show"); // Create Button object
        dispbutton.addActionListener(new DispButtonListener()); // Add Event Listener
        add(dispbutton); // Add the button object to this Frame
    }

    class DispButtonListener implements ActionListener { // Event Listener
        public void actionPerformed(ActionEvent e) { // What to do when the button is clicked
            contents.setText("Hello World!");
        }
    }

    public static void main(String[] args) {
        HelloAWT f = new HelloAWT(); // CreateHelloGUI
        f.setTitle("Hello!");
        f.setSize(400, 150);
        f.setVisible(true);
    }
} // end of “HelloAWT.java”
```
```
javac HelloAWT.java　コンパイル
java HelloAWT        実行
```

# Appletの具体例
## colorを変える
```java
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics; 

/*
<applet code="BlueString" width=300 height=100>
</applet> */

public class BlueString extends Applet {
public void paint(Graphics g) {
g.setColor(Color.blue);
g.drawString("Blue String", 100, 50); }
}
```

## 様々なtextを表示させる
```java
import java.applet.Applet;
import java.awt.*;

/*
<applet code="FontDemo" width=200 height=200>
</applet> */

public class FontDemo extends Applet { 
    
    public void paint(Graphics g) {
    // Draw baseline
    int baseline = 100;
    g.setColor(Color.lightGray);
    g.drawLine(0, baseline, 200, baseline);

    // Draw String
    g.setFont(new Font("Serif", Font.BOLD, 36));
    g.setColor(Color.black);
    g.drawString("Wxyz", 5, baseline); 
    }
}
```
## imageを表示する
```java
import java.applet.*;
import java.awt.*;

/*
<applet code="DrawImage" width=280 height=280> <param name="file" value="kids2.jpg">
</applet>
*/
public class DrawImage extends Applet { 
    Image image;

public void init() {
    image = getImage(getDocumentBase(),
    getParameter("file")); }
    public void paint(Graphics g) {
    g.drawImage(image, 0, 0, this); }
}
```

## Dimensionを使う
```java
import java.applet.*;
import java.awt.*; 

/*
<applet code="Circle" width=200 height=200>
</applet> */

public class Circle extends Applet {
    public void paint(Graphics g) {
    Dimension d = getSize();
    int xc = d.width / 2;
    int yc = d.height / 2;
    int radius = (int)((d.width < d.height) ?
    0.4 * d.width : 0.4 * d.height);
    g.drawOval(xc - radius, yc - radius, 2 * radius, 2 *
    radius); 
    }
}
```

## WebでAppletを使う
```java
import java.applet.*;
import java.awt.*;

/*
<applet code="AppletParameters" width=300 height=300>
<param name="background" value="0xffffff">
<param name="foreground" value="0x000000">
<param name="message" value="Testing AppletParameters">
</applet>
*/

public class AppletParameters extends Applet {
    public void paint(Graphics g) {
        String background = getParameter("background");
        String foreground = getParameter("foreground");
        String message = getParameter("message"); 

        setBackground(Color.decode(background)); 
        setForeground(Color.decode(foreground));
        Font font = getFont();
        FontMetrics fm = getFontMetrics(font);
        Dimension d = getSize();
        int x = (d.width - fm.stringWidth(message)) / 2; int y = d.height / 2;
        g.drawString(message, x, y);
    }
}
```


## appletContext interface
このインターフェースのメソッドをアプレット内で使用すると、そのアプレットの環境についての情報を取得できます。
```java
import java.applet.*;
import java.awt.*;
import java.net.*;

/*
<applet code="ShowDocument" width=200 height=50>
</applet> */

public class ShowDocument extends Applet {

public void init() {
    AppletContext ac = getAppletContext(); 
    try {
        URL url = new URL("http://www.osborne.com");
        ac.showDocument(url, "frame2"); 
    }
    catch(Exception e) { showStatus("Exception: " + e);
    } 
}

    public void paint(Graphics g) {
    g.drawString("ShowDocument Applet", 10, 25); 
    }
}
```

## 備考　Event Handling（old model sample code）
`Label set`と`OK`の2つのボタンからなるGUIでLavelsetのボタンをクリックするとLabel Set Button Clicked! と値が表示され、OKボタンがクリックされるとOK　Button Clicked!と表示されるjava appletプログラムです。  
`javac ファイル名`でjavaファイルをコンパイルし、`appletviewer ファイル名`でアプレットプログラムを実行します。
```java
//これは昔のモデルです！！
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<APPLET CODE=EventHandlingOld.class WIDTH=400 HEIGHT=200>
</APPLET> */

public class EventHandlingOld extends Applet { 
    String message = "";
    Button button1 = new Button("Label Set");//ボタン型のオブジェクト生成
    Button button2 = new Button("OK");
    
    public void init() {
    add(button1);//アプレット（コンテナに追加）
    add(button2);
    }

    public void paint(Graphics g) { 
        g.drawString(message, 20, 70);
    }

/* Old Model for Event Handling */
    public boolean action (Event e, Object arg) {
    if ( e.target instanceof Button ) { 
        if(e.target.equals(button1)){
        message = "Label Set Button Clicked!"; 
        } else if(e.target.equals(button2)){
        message = "OK Button Clicked!"; 
        }
        repaint();
    }
    return true; 
}
/* end of code for event handling */
} // End of the EventHandlingOld Class
```

# Lambda Expression
- using Anonymous class
    ```java
    dispbutton.addActionListener(new ActionListener() { // Using Anonymous Class 
        public void actionPerformed(ActionEvent e) {
            contents.setText("Hello World! - By Anonymous Class"); }
    }); // Using Anonymous Class
    add(dispbutton); //AddthebuttonobjecttothisFrame
    ```

- using Lambda expression
```java
dispbutton.addActionListener(e -> contents.setText("Hellow World! - By Lambda Expression"));
add(dispbutton); //AddthebuttonobjecttothisFrame
```

## 文法
### Event Listener
##### Anonymous class
```java
...
button1 = new JButton("foobar");
button1.addActionListener(this); 
...
public void actionPerformed(ActionEvent e) { 
    if (e.getSource() == button1) {
    //do something 
    }
...
}
...
```

##### Lambda expression
```java
...
button1 = new JButton("foobar");
button1.addActionListener(e -> button1Click()); 
...
public void button1Click() { 
    //do something
}
```

### Thread run method
##### Anonymous class
```java
Runnable runner = new Runnable() { 
    @Override
    public void run() {
    System.out.println("example"); 
    }
}; 
runner.run();
```

##### Lambda expression
```java
Runnable runner = () -> { System.out.println("example"); }; 
runner.run();
```

### Collection method
##### Anonymous class
```java
List<Integer> list = Arrays.asList(1, 3, 2); 
Collections.sort(list, new Comparator<Integer>() {
@Override
public int compare(Integer o1, Integer o2) {
return Integer.compare(o1, o2); }
}
);
```
##### Lambda expression
```java
List<Integer> list = Arrays.asList(1, 3, 2); 
Collections.sort(list, (o1, o2) -> Integer.compare(o1, o2));
```