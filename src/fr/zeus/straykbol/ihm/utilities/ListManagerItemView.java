package fr.zeus.straykbol.ihm.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import fr.zeus.straykbol.R;

public class ListManagerItemView extends TextView {
	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;

	public ListManagerItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	public ListManagerItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public ListManagerItemView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		Resources myResources = getResources();
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myResources.getColor(R.color.notepad_lines));
		paperColor = myResources.getColor(R.color.notepad_paper);
		margin = myResources.getDimension(R.dimen.notepad_margin);
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(paperColor);
		canvas.drawLine(0, 0, getMeasuredHeight(), 0, linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
		canvas.save();
		canvas.translate(margin, 0);

		super.onDraw(canvas);
		canvas.restore();
	}
}
