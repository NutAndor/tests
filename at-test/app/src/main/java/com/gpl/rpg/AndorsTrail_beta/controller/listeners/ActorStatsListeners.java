package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.actor.Actor;
import com.gpl.rpg.AndorsTrail_beta.model.actor.Player;
import com.gpl.rpg.AndorsTrail_beta.util.ListOfListeners;

public final class ActorStatsListeners extends ListOfListeners<ActorStatsListener> implements ActorStatsListener {

	private final Function1<ActorStatsListener, Actor> onActorHealthChanged = new Function1<ActorStatsListener, Actor>() {
		@Override public void call(ActorStatsListener listener, Actor actor) { listener.onActorHealthChanged(actor); }
	};

	private final Function1<ActorStatsListener, Actor> onActorAPChanged = new Function1<ActorStatsListener, Actor>() {
		@Override public void call(ActorStatsListener listener, Actor actor) { listener.onActorAPChanged(actor); }
	};

	private final Function2<ActorStatsListener, Actor, Integer> onActorAttackCostChanged = new Function2<ActorStatsListener, Actor, Integer>() {
		@Override public void call(ActorStatsListener listener, Actor actor, Integer newAttackCost) { listener.onActorAttackCostChanged(actor, newAttackCost); }
	};

	private final Function2<ActorStatsListener, Actor, Integer> onActorMoveCostChanged = new Function2<ActorStatsListener, Actor, Integer>() {
		@Override public void call(ActorStatsListener listener, Actor actor, Integer newMoveCost) { listener.onActorMoveCostChanged(actor, newMoveCost); }
	};
	
	private final Function2<ActorStatsListener, Player, Integer> onPlayerReequipCostChanged = new Function2<ActorStatsListener, Player, Integer>() {
		@Override public void call(ActorStatsListener listener, Player actor, Integer newAttackCost) { listener.onPlayerReequipCostChanged(actor, newAttackCost); }
	};

	private final Function2<ActorStatsListener, Player, Integer> onPlayerUseCostChanged = new Function2<ActorStatsListener, Player, Integer>() {
		@Override public void call(ActorStatsListener listener, Player actor, Integer newMoveCost) { listener.onPlayerUseCostChanged(actor, newMoveCost); }
	};

	@Override
	public void onActorHealthChanged(Actor actor) {
		callAllListeners(this.onActorHealthChanged, actor);
	}

	@Override
	public void onActorAPChanged(Actor actor) {
		callAllListeners(this.onActorAPChanged, actor);
	}

	@Override
	public void onActorAttackCostChanged(Actor actor, int newAttackCost) {
		callAllListeners(this.onActorAttackCostChanged, actor, newAttackCost);
	}

	@Override
	public void onActorMoveCostChanged(Actor actor, int newMoveCost) {
		callAllListeners(this.onActorMoveCostChanged, actor, newMoveCost);
	}
	

	@Override
	public void onPlayerReequipCostChanged(Player actor, int newAttackCost) {
		callAllListeners(this.onPlayerReequipCostChanged, actor, newAttackCost);
	}

	@Override
	public void onPlayerUseCostChanged(Player actor, int newMoveCost) {
		callAllListeners(this.onPlayerUseCostChanged, actor, newMoveCost);
	}
}
