package org.firstinspires.ftc.teamcode.vision;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class VisionPipeline extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();

    static final Rect leftBox = new Rect(new Point(0, 40), new Point(106, 140));
    static final Rect rightBox = new Rect(new Point(106, 40), new Point(212, 140));
    static final Rect centerBox = new Rect(new Point(212, 40), new Point(318, 140));



    public enum Pos {
        LEFT,
        RIGHT,
        CENTER
    }

    private Pos position;

    public VisionPipeline(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(23, 50, 70);
        Scalar highHSV = new Scalar(32, 255, 255);
        Core.inRange(mat, lowHSV, highHSV, mat);
        Mat left = mat.submat(leftBox);
        Mat center  = mat.submat(centerBox);
        Mat right = mat.submat(rightBox);
        double leftValue = Core.sumElems(left).val[0]/leftBox.area()/255;
        double centerValue = Core.sumElems(center).val[0]/centerBox.area()/255;
        double rightValue = Core.sumElems(right).val[0]/centerBox.area()/255;
        left.release();
        center.release();
        right.release();

        double max1 = Math.max(leftValue, centerValue);
        double max2 = Math.max(max1, rightValue);
         if(max2 == leftValue)
         {
             position = Pos.LEFT;
         }
         else if(max2 == rightValue)
         {
             position = Pos.RIGHT;
         }
         else
         {
             position = Pos.CENTER;
         }
         telemetry.addData("Target", position);
         telemetry.update();

         Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);
         Scalar colorTarget = new Scalar(0, 225, 0);
         Scalar colorEmpty = new Scalar (225, 0, 0);
         Imgproc.rectangle(mat, leftBox, position == Pos.LEFT ? colorTarget:colorEmpty);
        Imgproc.rectangle(mat, centerBox, position == Pos.CENTER ? colorTarget:colorEmpty);
        Imgproc.rectangle(mat, rightBox, position == Pos.RIGHT ? colorTarget:colorEmpty);
        return mat;
    }
    public Pos getPosition()
    {
        return position;
    }

}
