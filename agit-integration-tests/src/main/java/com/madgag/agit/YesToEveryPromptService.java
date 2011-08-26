/*
 * Copyright (c) 2011 Roberto Tyley
 *
 * This file is part of 'Agit' - an Android Git client.
 *
 * Agit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Agit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.madgag.agit;

import android.util.Log;
import com.google.inject.Module;
import com.madgag.agit.operations.OpPrompt;
import com.madgag.android.blockingprompt.BlockingPromptService;
import roboguice.config.AbstractAndroidModule;

import static java.lang.Boolean.TRUE;

public final class YesToEveryPromptService implements BlockingPromptService {

    private static final String TAG = "YTEPS";

	public static Module module() {
		return new AbstractAndroidModule() {
			@Override
			protected void configure() {
				bind(BlockingPromptService.class).toInstance(new YesToEveryPromptService());
			}
		};
	}

    public <T> T request(OpPrompt<T> opPrompt) {
        if (opPrompt.getRequiredResponseType().equals(Boolean.class)) {
            Log.e(TAG,"Returning true for "+opPrompt);
            return (T) TRUE;
        }
        try {
            return opPrompt.getRequiredResponseType().newInstance();
        } catch (Exception e) {
            Log.e(TAG,"Whoops",e);
            return null;
        }
    }
}