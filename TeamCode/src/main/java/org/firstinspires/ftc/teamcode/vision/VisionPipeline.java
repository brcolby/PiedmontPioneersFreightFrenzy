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

    static final Rect LEFTBOX = new Rect(
            new Point(0, 140),
            new Point(106, 240)
    );
    static final Rect CENTERBOX = new Rect(
            new Point(106, 140),
            new Point(212, 240)
    );
    static final Rect RIGHTBOX = new Rect(
            new Point(212, 140),
            new Point(320, 240)
    );

    public enum POS {
        LEFT,
        RIGHT,
        CENTER
    }
    private POS pos;

    public VisionPipeline(Telemetry t) {
        telemetry = t;
    }

    public Mat processFrame(Mat input) {
        // convert RBB to HSV
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(25, 50, 70); // duck lower
        Scalar highHSV = new Scalar(28, 255, 255); // duck upper

        // convert to b/w by removing all colors not in range
        Core.inRange(mat, lowHSV, highHSV, mat);

        // create 3 submats for left/right/center
        Mat left = mat.submat(LEFTBOX);
        Mat center = mat.submat(CENTERBOX);
        Mat right = mat.submat(RIGHTBOX);

        // get val for each submat by dividing average hue by area of box
        double leftValue = Core.sumElems(left).val[0] / LEFTBOX.area() / 255;
        double centerValue = Core.sumElems(center).val[0] / CENTERBOX.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / RIGHTBOX.area() / 255;

        left.release();
        center.release();
        right.release();

        // max = max value (highest amount of green/yellow)
        double maxLeftRight = Math.max(leftValue, rightValue);
        double max = Math.max(maxLeftRight, centerValue);

        if (max == leftValue)
            pos = POS.LEFT;
        else if (max == centerValue)
            pos = POS.CENTER;
        else if (max == rightValue)
            pos = POS.RIGHT;

        telemetry.addData("Vision target location: ", pos);
        telemetry.update();

        // b/w to RGB
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);
        Scalar colorTarget = new Scalar(0, 255, 0);
        Scalar colorEmpty = new Scalar(255, 0, 0);

        // draw green rect on target box/red on empty box
        Imgproc.rectangle(mat, LEFTBOX, pos == POS.LEFT ? colorTarget:colorEmpty);
        Imgproc.rectangle(mat, CENTERBOX, pos == POS.CENTER ? colorTarget:colorEmpty);
        Imgproc.rectangle(mat, RIGHTBOX, pos == POS.RIGHT ? colorTarget:colorEmpty);

        return mat;
    }

    public POS getPosition() {
        return pos;
    }
}
