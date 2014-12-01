package org.translifeline.cupcakehotline.objectify;

import org.translifeline.cupcakehotline.models.Call;
import org.translifeline.cupcakehotline.models.Caller;
import org.translifeline.cupcakehotline.models.Operator;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {
	static {
        factory().register(Call.class);
        factory().register(Caller.class);
        factory().register(Operator.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
