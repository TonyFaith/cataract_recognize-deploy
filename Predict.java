package classify;

import org.opencv.core.Core;

public class Predict {
	/**
	 * 图片识别主方法
	 * @param obj
	 * @param modelDir
	 * @param imgPath
	 * @param dealImgPath
	 * @param rReduceRate
	 * @param centerLeftRate
	 * @param lightA1
	 * @param lightB1
	 * @param lightA2
	 * @param lightB2
	 */
	 public static void main(String[] args){	  
	      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	      
	      ImgPreproc preproc = new ImgPreproc();
	      LabelImage predict = new LabelImage();
	      //配置图像和模型路径
	      String modelDir = "/home/inferrr/eclipse-workspace/TensorflowClassify/model";         
	      String imgPath = "/home/inferrr/eclipse-workspace/TensorflowClassify/image/test1.jpg";
	      String dealImgPath = "/home/inferrr/eclipse-workspace/TensorflowClassify/image/test1_deal.jpg";   
	      //配置图像预处理的参数 
	      double rReduceRate=0.1;
	      double centerLeftRate = 0.12;
	      double lightA1 = 2.3;
	      double lightB1 = 10;
	      double lightA2 = 1.5;
	      double lightB2 = 10;
	      //进行图像预处理和图像识别
	      long startTime = System.currentTimeMillis();    //获取开始时间
	      preproc.imgPreprocess(preproc, imgPath, dealImgPath, rReduceRate, centerLeftRate, lightA1, lightB1, lightA2, lightB2);
	      String result = predict.labelImg(modelDir, dealImgPath);
	      //显示预测结果
	      System.out.println("源图片： " + imgPath);
	      System.out.println("处理后图片： " + dealImgPath);
	      System.out.println("预测结果：" + result);
	      long endTime = System.currentTimeMillis();    //获取结束时间
	      System.out.println("图片处理总耗时：" + (endTime - startTime) + "ms");
	      
	   }
	 
	 public static String predict(String modelDir,String imgPath,String dealImgPath){	  
	      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);   
	      //配置图像预处理的参数  
	      double rReduceRate=0.1;
	      double centerLeftRate = 0.12;
	      double lightA1 = 2.3;
	      double lightB1 = 10;
	      double lightA2 = 1.5;
	      double lightB2 = 10;
	      //进行图像预处理和图像识别
	      ImgPreproc preproc = new ImgPreproc();
	      LabelImage predict = new LabelImage();
	      preproc.imgPreprocess(preproc, imgPath, dealImgPath, rReduceRate, centerLeftRate, lightA1, lightB1, lightA2, lightB2);
	      String result = predict.labelImg(modelDir, dealImgPath);
	      //返回结果 
	      return result;
	   }

}
