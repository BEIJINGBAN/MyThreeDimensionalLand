-- 测试目标
CREATE TABLE target (
                        id          INTEGER PRIMARY KEY AUTOINCREMENT,
                        name        TEXT NOT NULL,
                        url         TEXT NOT NULL,
                        created_at  TEXT NOT NULL DEFAULT (datetime('now', 'localtime')),
                        updated_at  TEXT NOT NULL DEFAULT (datetime('now', 'localtime'))
);

-- 测试结果
CREATE TABLE probe_result (
                              id          INTEGER PRIMARY KEY AUTOINCREMENT,
                              target_id   INTEGER NOT NULL REFERENCES target(id) ON DELETE CASCADE,
                              status_code INTEGER,                          -- 连不上时为 NULL
                              latency_ms  INTEGER,                          -- 连不上时为 NULL
                              success     INTEGER NOT NULL DEFAULT 0,
                              created_at  TEXT NOT NULL DEFAULT (datetime('now', 'localtime'))
);

-- 外键列必须手动建索引（下面解释为什么）
CREATE INDEX idx_result_target  ON probe_result (target_id, created_at DESC);
CREATE INDEX idx_result_created ON probe_result (created_at DESC);
