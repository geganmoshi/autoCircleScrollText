# autoCircleScrollText
android autoCircleScrollText

安卓实现文字圆形滚动控件，支持顺时针和逆时针滚动，该控件只支持1080*1920像素，未进行其它分辨率的适配

调用方法：


  <com.xxx.view.autoCircleScrollText
    android:id="@+id/circle_rec"
    android:layout_height="wrap_content"
    android:layout_width="550px"
    android:layout_marginLeft="210px"
    android:layout_marginTop="200px">
  </com.xxx.view.autoCircleScrollText>

 circle_rec = (autoCircleScrollText)findViewById(R.id.circle_rec);
 //输入参数，内圈滚动文字，外圈滚动文字
 circle_rec.setText(out_text,inner_text);
