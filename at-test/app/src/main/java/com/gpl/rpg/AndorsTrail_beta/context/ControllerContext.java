package com.gpl.rpg.AndorsTrail_beta.context;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.Resources;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.AndorsTrailPreferences;
import com.gpl.rpg.AndorsTrail_beta.controller.ActorStatsController;
import com.gpl.rpg.AndorsTrail_beta.controller.CombatController;
import com.gpl.rpg.AndorsTrail_beta.controller.ConversationController;
import com.gpl.rpg.AndorsTrail_beta.controller.GameRoundController;
import com.gpl.rpg.AndorsTrail_beta.controller.InputController;
import com.gpl.rpg.AndorsTrail_beta.controller.ItemController;
import com.gpl.rpg.AndorsTrail_beta.controller.MapController;
import com.gpl.rpg.AndorsTrail_beta.controller.MonsterMovementController;
import com.gpl.rpg.AndorsTrail_beta.controller.MonsterSpawningController;
import com.gpl.rpg.AndorsTrail_beta.controller.MovementController;
import com.gpl.rpg.AndorsTrail_beta.controller.SkillController;
import com.gpl.rpg.AndorsTrail_beta.controller.VisualEffectController;

public final class ControllerContext {
	//Controllers
	public final MapController mapController;
	public final GameRoundController gameRoundController;
	public final CombatController combatController;
	public final ConversationController conversationController;
	public final VisualEffectController effectController;
	public final ItemController itemController;
	public final MonsterMovementController monsterMovementController;
	public final MonsterSpawningController monsterSpawnController;
	public final MovementController movementController;
	public final ActorStatsController actorStatsController;
	public final InputController inputController;
	public final SkillController skillController;

	public final AndorsTrailPreferences preferences;
	private final WeakReference<AndorsTrailApplication> app;

	public ControllerContext(AndorsTrailApplication app, WorldContext world) {
		this.app = new WeakReference<AndorsTrailApplication>(app);
		this.preferences = app.getPreferences();

		this.mapController = new MapController(this, world);
		this.gameRoundController = new GameRoundController(this, world);
		this.combatController = new CombatController(this, world);
		this.conversationController = new ConversationController(this, world);
		this.effectController = new VisualEffectController(this, world);
		this.itemController = new ItemController(this, world);
		this.monsterMovementController = new MonsterMovementController(this, world);
		this.monsterSpawnController = new MonsterSpawningController(this, world);
		this.movementController = new MovementController(this, world);
		this.actorStatsController = new ActorStatsController(this, world);
		this.inputController = new InputController(this, world);
		this.skillController = new SkillController(this, world);
	}

	public Resources getResources() {
		return app.get().getResources();
	}
	public Context getContext() {return app.get().getApplicationContext(); }
}
