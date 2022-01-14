package com.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSliderimagesEntity is a Querydsl query type for SliderimagesEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSliderimagesEntity extends EntityPathBase<SliderimagesEntity> {

    private static final long serialVersionUID = -1703169640L;

    public static final QSliderimagesEntity sliderimagesEntity = new QSliderimagesEntity("sliderimagesEntity");

    public final StringPath Activity = createString("Activity");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleteFlg = createString("deleteFlg");

    public final StringPath filename = createString("filename");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath sortNo = createString("sortNo");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QSliderimagesEntity(String variable) {
        super(SliderimagesEntity.class, forVariable(variable));
    }

    public QSliderimagesEntity(Path<? extends SliderimagesEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSliderimagesEntity(PathMetadata metadata) {
        super(SliderimagesEntity.class, metadata);
    }

}

