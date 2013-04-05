package com.example.playmake;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Offense extends Activity implements OnTouchListener{

	    private ImageView center;                       // The letter that the user drags.
	    //private ImageView emptycenter;              // The letter outline that the user is supposed to drag center to.
	    private AbsoluteLayout mainLayout;
	    private ImageView lineofscrim;



	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offense);
        
      //  final ImageButton img1 = (ImageButton) findViewById(R.id.imageButton1);
        mainLayout = (AbsoluteLayout) findViewById(R.id.mainLayout);
        mainLayout.setOnTouchListener(this);
        center = (ImageView) findViewById(R.id.center);
        lineofscrim = (ImageView) findViewById(R.id.lineofscrim);
        lineofscrim.setFocusable(false);
        center.setOnTouchListener(this);
        //center.setOnClickListener(this);
        center.clearFocus();
        center.setFocusable(true);

        //emptycenter = (ImageView) findViewById(R.id.emptycenter);
      
         
	}
        public boolean onTouch(View v, MotionEvent event) {
        	Rect hitRect = new Rect();
        	boolean dragging = false;
        	boolean clicked = false;
            boolean eventConsumed = true;
            int x = (int)event.getX();
            int y = (int)event.getY();

            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                if (v == center) {
                	center.requestFocusFromTouch();
                	center.getHitRect(hitRect);
                	if (hitRect.contains(x, y)){
                		clicked = true;
                	}
                    dragging = true;
                    eventConsumed = false;
                }
            } else if (action == MotionEvent.ACTION_UP) {

            	
            	
               // if (dragging) {
                    //emptycenter.getHitRect(hitRect);
                   // if (hitRect.contains(x, y))
                    //    setSameAbsoluteLocation(center, mainLayout);
               // }
            	if (center.hasFocus() == true && y<320 && y>10){
            		//center.setX(x);
                	center.setY(y-20);
                	lineofscrim.setY(y);
                	//center.clearFocus();
            	}
            	
            	
            	//Destroy first image replace with 5 seperate circles at that spot
            	
                dragging = false;
                eventConsumed = false;

            } else if (action == MotionEvent.ACTION_MOVE) {
               // if (v == center) {
                    //if (clicked == true) {
                        //setAbsoluteLocationCentered(center, x, y);
            	if (center.hasFocus() == true){
            		//center.setX(x);
                	center.setY(y-20);
                	lineofscrim.setY(y);
            	}
                   // }
               // }
                
            }
            return eventConsumed;
        }


    
        
       //img1.setOnClickListener(new View.OnClickListener() {

		/*	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//float x = event.getX();
               // float y = event.getY();
				//img1.setX(x);
				//img1.setY(y);
			}
		});*/
       
         
        //img1.setOnDragListener(new OnDragListener() {
           // @Override
           /* public boolean onDrag(View v, MotionEvent event) {
            	float x = event.getX();
                float y = event.getY();
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    //increaseSize();
                	img1.setX(x);
                	img1.setY(y);
                } 
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //resetSize();
                	img1.setX(x);
                	img1.setY(y);
                	
                }
                else if (event.getAction() == MotionEvent.ACTION_MOVE){
                	img1.setX(x);
                	img1.setY(y);
                	
                }
                //else if (event.getAction() == MotionEvent.)
                
                return true;
            }*/


			/*@Override
			public boolean onDrag(View arg0, DragEvent arg1) {
				float x = arg1.getX();
                float y = arg1.getY();
                if(arg1.getAction() == DragEvent.ACTION_DRAG_STARTED) {
                    //increaseSize();
                	
                	img1.setX(x);
                	img1.setY(y);
                } 
                else if (arg1.getAction() == DragEvent.ACTION_DRAG_ENDED) {
                    //resetSize();
                	img1.setX(x);
                	img1.setY(y);
                	
                }
               else if (arg1.getAction() == DragEvent.ACTION_DRAG_ENTERED){
                	img1.setX(x);
                	img1.setY(y);
                	
                }
               else if (arg1.getAction() == DragEvent.ACTION_DRAG_EXITED){
               	img1.setX(x);
               	img1.setY(y);
               	
               }
               else if (arg1.getAction() == DragEvent.ACTION_DRAG_LOCATION){
                  	img1.setX(x);
                  	img1.setY(y);
                  	
                  }
               else if (arg1.getAction() == DragEvent.ACTION_DROP){
                 	img1.setX(x);
                 	img1.setY(y);
                 	
                 }
                
				return true;
			}
        });
        
        
	}*/

	//@SuppressWarnings({ "deprecation", "unused" })
	private void setSameAbsoluteLocation(View v1, View v2) {
        AbsoluteLayout.LayoutParams alp2 = (AbsoluteLayout.LayoutParams) v2.getLayoutParams();
        setAbsoluteLocation(v1, alp2.x, alp2.y);
    }


    @SuppressWarnings("unused")
	private void setAbsoluteLocationCentered(View v, int x, int y) {
        setAbsoluteLocation(v, x - v.getWidth() / 2, y - v.getHeight() / 2);
    }


    @SuppressWarnings("deprecation")
	private void setAbsoluteLocation(View v, int x, int y) {
		AbsoluteLayout.LayoutParams alp = (AbsoluteLayout.LayoutParams) v.getLayoutParams();
        alp.x = x;
        alp.y = y;
        v.setLayoutParams(alp);
    }
}