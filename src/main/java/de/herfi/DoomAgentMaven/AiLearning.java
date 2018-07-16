package de.herfi.DoomAgentMaven;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import java.io.IOException;

import org.datavec.image.loader.NativeImageLoader;
import org.nd4j.linalg.api.ndarray.INDArray;

import static org.bytedeco.javacpp.opencv_imgcodecs.*;

import vizdoom.GameState;
import vizdoom.Label;


public class AiLearning {
	
	GameState state;
	
	int n;              
    double[] vars;       
    byte[] screenBuf;
    byte[] depthBuf;
    byte[] labelsBuf;
    byte[] automapBuf;
    Label[] labels;
	

	public AiLearning() {
		// TODO Auto-generated constructor stub
	}
	
	public void refreshState(GameState state) throws IOException {
		this.state = state;
		
		this.n = state.number;
		this.vars = state.gameVariables;
		this.screenBuf= state.screenBuffer;
		this.depthBuf= state.depthBuffer;
		this.labelsBuf= state.labelsBuffer;
		this.automapBuf= state.automapBuffer;
		this.labels= state.labels;
		
		NativeImageLoader loader = new NativeImageLoader();
		Mat mat = new Mat(screenBuf);
		
		INDArray a = loader.asMatrix(mat);
		//INDArray a = loader.asMatrix(screenBuf);
		
		//System.out.println(a);


	
		
	}
	

}
