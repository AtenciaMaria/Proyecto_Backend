package culturemedia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;
import org.springframework.stereotype.Service;

@Service
public class ViewsRepositoryImpl implements ViewsRepository {

	private final List<View> views;

	public ViewsRepositoryImpl() {
		this.views = new ArrayList<>();
	}

	@Override
	public View agregar(View view) {
		this.views.add( view );
		return view;
	}
}
