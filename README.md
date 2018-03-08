# 项目介绍：
   眼睛是人类与世界沟通的桥梁，也是心灵的窗户。然而，在中国农村和偏远地区，由于缺乏有经验的医生和有效的设备，同时很多中老年人对眼部疾患不够重视，导致大部分眼疾患者难以及时发现，等到眼疾恶化，对视觉系统造成严重影响时才寻求治疗，但已错过最佳治疗时机，难以康复。事实上，有大量农村老人晚年患上严重眼疾，甚至失明。
    基于深度学习的白内障识别项目旨在实现基于手机客户端的白内障识别。患者通过手机客户端拍摄眼部图像，上传服务器，通过人工智能程序进行识别判定，最终将判断结果(是否患白内障)在手机客户端显示。本程序完成了项目的关键部分—基于眼部图像的白内障病情自动识别。支撑系统实现对每张图像的识别时间控制在1s以内。通过对约1000名患者的测试表明，系统对白内障患者(含轻度白内障)的检出率达到99%以上，对轻度白内障患者的检出率达到94.9%。

# 安装部署：(详见模型部署java代码)
  本程序的安装配置过程如下：（以Ubuntu14.04为例，不适用于macos/windows系统)
      1.安装Java，配置Java环境(测试使用Jdk1.8.0_144,未发现对java环境的特殊依赖），安装Eclipse。(过程略）
      2.配置项目环境
        2.0 在eclipse中创建新的Java项目
        2.1 添加基于linux内核系统的opencv库包及.so文件（文件路径：test_jar/addlibrary/opencv-300.jar,addlibrary/libopencv_java300.so）       
        2.2 添加基于linux内核系统的tensorflow库包。（test_jar/addlibrary/libtensorflow-1.2.1.jar,addlibrary/libtensorflow_jni.so)
        2.3（可选，对应程序运行中的第一种方法）添加白内障自动识别jar包。（test_jar/addlibrary/cataractr_recognize_3.jar)

 # 程序运行: 
   配置好系统和项目环境后，正确设置待识别图像和模型路径，可通过运行jar包和源代码的形式运行程序。
   一、jar包方式运行：
      该方法不关注程序的实现细节，将所有代码封装，安全、便捷。需要在配置环境时完成第2.3步。具体步骤如下：
      1.更改文件路径
         项目源文件位于test_jar/src/jar_use.java，添加到所建项目的src下。
         打开jar_use.java文件，根据实际保存的文件位置更改输入图像路径(imgPath)，模型路径(modelDir)，中间图像路径(dealImgPath)（注：中间图像为程序运行过程中生成的过渡图像，名称任取，无需更改）。
        (提供的模型文件:test_jar/model/3classes_1222.pb,synsets_22.txt，供选用的输入图像:image/test1.jpg)
      2.运行jar_use.java,输出识别结果，为“预测结果：轻度”、“预测结果：白内障”、“预测结果：正常” 三者之一。
   二、源文件方式运行：
      选择该方法可略过步骤2.3。
      该程序主要包含ImgPreproc.java、LabelImage.java,分别完成图像预处理和图像识别过程(文件均包含main函数）,及Predict.java，其中含项目主函数。
      1.更改文件路径
          将ImgPreproc.java、LabelImage.java,Predict.java添加到所建项目的src下。（文件位于test_jar/src 下）
          打开Predict.java,根据实际保存的文件位置更改输入图像路径(imgPath)，模型路径(modelDir)，中间图像路径(dealImgPath)（注：中间图像为程序运行过程中生成的过渡图像，名称任取，无需更改）。
      2.运行Predict.java文件，得到输出结果，包含运行时间的统计。

# 模型训练-测试:（详见模型训练python代码）
  一：环境部署：(小括号为测试使用的标准环境，其它版本也可）
      1.系统环境：linux核心系统（Centos 7）
      2.GPU加速的tensorflow(1.2)，keras(2.0.8)，opencv,numpy,skimage,matplotlib,jupyter notebook等。
      安装参见链接：https://www.jianshu.com/u/fe6ad13ea558
   二:训练模型：
      激活tensorflow环境：source activate 环境名称
      打开Jupiter notebook: 终端输入 jupyter notebook --ip=（ip地址 ），点击给出的网址，在浏览器中打开交互式界面。
      包括： (打开文件后，点击shift+enter即可运行相应代码）
          1.白内障数据处理：image_process.ipynb  (位于模型训练代码的scripts文件夹下）
          2.模型训练：train_val.ipynb
          3.模型测试：test_model.ipynb
          4.模型转换：transform_model.ipynb
      相关备注及使用方法见以上代码文件。
          

# 版本更新与备注：
   版本1：2018.02.23   备注：无

# 开发人员与联系方式：
   版本1：2018.02.23    备注：无
   吴建宝   343513404@qq.com  18701373637
