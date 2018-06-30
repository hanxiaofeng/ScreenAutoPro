# ScreenAutoPro

#### 手机屏幕适配大全，目前常用的适配方式总结

[![Latest Version](https://img.shields.io/packagist/v/intervention/image.svg)](https://packagist.org/packages/intervention/image)
[![Build Status](https://travis-ci.org/Intervention/image.png?branch=master)](https://travis-ci.org/Intervention/image)

### 1.App:今日头条适配方式

android中的dp在渲染前会将dp转为px，
计算公式：
* px = density * dp;
* density = dpi / 160;
* px = dp * (dpi / 160);



使用方式：

* 拿到设计图后，尺寸除以2，xml指定测量后的值/2，单位为dp，如果使用原图，字体scaleDensity*2
宽高只能以某个为适配基准，要么以宽为基准，要么以高为基准。

* 比如：UI给的效果图为：1334*750，宽高除以2后为667，375，在setAppOrientation方法里设置宽高值667，375，
在xml里通过markman测量的大小除以2，然后以dp为单位写死即可。

<b>具体使用方式请看Demo----App;</b>

### 2.swscreenauto:sw适配方式

使用方式：根据swdimenUtils工程生成对应的swXXXdp文件，然后在xml中直接使用即可;

注意：swscreenauto/swdimenUtils 用于生成values-swXXXdp文件，此适配方式是以宽度为基准进行适配，会根据手机分辨率自动找到对应的dimen值，如果找不到会向下找到最近的sw目录，适配可适应性高。


### 3.pxscreenauto:values-1920x1080适配方式

使用方式：固定分辨率适配，自动根据屏幕分辨率进行适配，但需要提供所有的分辨率才可以保证全部适配，所以在特殊设备上可能找不到对应的分辨率，小程度存在适配问题。

注意：values下也要放置一组默认分辨率的xml文件，不然找不到会出现错误。
