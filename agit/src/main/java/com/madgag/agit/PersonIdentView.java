package com.madgag.agit;

import static com.madgag.android.lazydrawables.gravatar.Gravatars.gravatarIdFor;

import org.eclipse.jgit.lib.PersonIdent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.madgag.android.lazydrawables.ImageSession;

public class PersonIdentView extends LinearLayout {
	
	private static final String TAG = "PIV";
	
	private final ImageView avatarView;
	private final TextView nameView;
	
	public PersonIdentView(Context context, AttributeSet attrs) {
		super(context, attrs);	
		LayoutInflater.from(context).inflate(R.layout.person_ident_view, this);
		
		avatarView = (ImageView) findViewById(R.id.person_ident_avatar);
		nameView = (TextView) findViewById(R.id.person_ident_name);
	}
	
	
	public void setIdent(ImageSession<String,Bitmap> is, PersonIdent ident) {
		Drawable avatar = is.get(gravatarIdFor(ident.getEmailAddress()));
		avatarView.setImageDrawable(avatar);
		nameView.setText(ident.getName());
	}	
}