package hr.fer.zemris.fuzzy.utils;

import hr.fer.zemris.fuzzy.utils.domain.Domain;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

public class ModelDomains {
    public static IDomain AKCELERATION = Domain.intRange(-10, 31);
    public static IDomain VELOCITY = Domain.intRange(0, 201);

    public static IDomain ANGLE = Domain.intRange(-90, 91);
    public static IDomain DISTANCE = Domain.intRange(0, 1301);

    public static IDomain DIRECTION = Domain.intRange(0, 2);
}
