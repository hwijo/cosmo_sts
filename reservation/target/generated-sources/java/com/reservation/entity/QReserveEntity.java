package com.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReserveEntity is a Querydsl query type for ReserveEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReserveEntity extends EntityPathBase<ReserveEntity> {

    private static final long serialVersionUID = -1371123581L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReserveEntity reserveEntity = new QReserveEntity("reserveEntity");

    public final StringPath adult = createString("adult");

    public final StringPath bankBranchCde = createString("bankBranchCde");

    public final StringPath bankName = createString("bankName");

    public final StringPath bankNo = createString("bankNo");

    public final NumberPath<Integer> buildCd = createNumber("buildCd", Integer.class);

    public final StringPath cancelFlg = createString("cancelFlg");

    public final StringPath child = createString("child");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath deleteFlg = createString("deleteFlg");

    public final StringPath endDate = createString("endDate");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath options = createString("options");

    public final StringPath paymentFlg = createString("paymentFlg");

    public final StringPath phone = createString("phone");

    public final QRoomInfoEntity roomInfoEntity;

    public final StringPath startDate = createString("startDate");

    public final NumberPath<Integer> totalcost = createNumber("totalcost", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QReserveEntity(String variable) {
        this(ReserveEntity.class, forVariable(variable), INITS);
    }

    public QReserveEntity(Path<? extends ReserveEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReserveEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReserveEntity(PathMetadata metadata, PathInits inits) {
        this(ReserveEntity.class, metadata, inits);
    }

    public QReserveEntity(Class<? extends ReserveEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomInfoEntity = inits.isInitialized("roomInfoEntity") ? new QRoomInfoEntity(forProperty("roomInfoEntity")) : null;
    }

}

