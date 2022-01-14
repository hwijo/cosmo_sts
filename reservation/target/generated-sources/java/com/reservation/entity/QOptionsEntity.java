package com.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOptionsEntity is a Querydsl query type for OptionsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionsEntity extends EntityPathBase<OptionsEntity> {

    private static final long serialVersionUID = -2044045083L;

    public static final QOptionsEntity optionsEntity = new QOptionsEntity("optionsEntity");

    public final StringPath Activity = createString("Activity");

    public final NumberPath<Integer> buildCd = createNumber("buildCd", Integer.class);

    public final StringPath cost = createString("cost");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleteFlag = createString("deleteFlag");

    public final StringPath item = createString("item");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QOptionsEntity(String variable) {
        super(OptionsEntity.class, forVariable(variable));
    }

    public QOptionsEntity(Path<? extends OptionsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionsEntity(PathMetadata metadata) {
        super(OptionsEntity.class, metadata);
    }

}

