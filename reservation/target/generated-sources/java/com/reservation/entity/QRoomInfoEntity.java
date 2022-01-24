package com.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomInfoEntity is a Querydsl query type for RoomInfoEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoomInfoEntity extends EntityPathBase<RoomInfoEntity> {

    private static final long serialVersionUID = 24832296L;

    public static final QRoomInfoEntity roomInfoEntity = new QRoomInfoEntity("roomInfoEntity");

    public final NumberPath<Integer> adultCost = createNumber("adultCost", Integer.class);

    public final NumberPath<Integer> buildCd = createNumber("buildCd", Integer.class);

    public final NumberPath<Integer> childCost = createNumber("childCost", Integer.class);

    public final StringPath colorCd = createString("colorCd");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleteFlg = createString("deleteFlg");

    public final StringPath explnation = createString("explnation");

    public final StringPath images = createString("images");

    public final NumberPath<Integer> max = createNumber("max", Integer.class);

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath roomNum = createString("roomNum");

    public final StringPath roomTitle = createString("roomTitle");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QRoomInfoEntity(String variable) {
        super(RoomInfoEntity.class, forVariable(variable));
    }

    public QRoomInfoEntity(Path<? extends RoomInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomInfoEntity(PathMetadata metadata) {
        super(RoomInfoEntity.class, metadata);
    }

}

