# autoCircleScrollText
### android autoCircleScrollText

## 安卓实现文字圆形滚动自定义控件，支持顺时针和逆时针滚动，该控件只支持1080*1920像素，未进行其它分辨率的适配

## 调用方法：


  > <com.xxx.view.autoCircleScrollText <br> 
  >  android:id="@+id/circle_rec"<br> 
  >  android:layout_height="wrap_content"<br> 
  >  android:layout_width="550px"<br> 
  >  android:layout_marginLeft="210px"<br> 
  >  android:layout_marginTop="200px"><br> 
  > </com.xxx.view.autoCircleScrollText><br> 

 circle_rec = (autoCircleScrollText)findViewById(R.id.circle_rec);<br> 
 //输入参数，内圈滚动文字，外圈滚动文字<br> 
 circle_rec.setText(out_text,inner_text);<br> 
